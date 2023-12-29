package bitcamp.util;

import java.util.Arrays;

public class LinkedList<E> extends AbstractList<E> {

  private Node<E> first;
  private Node<E> last;

  public void add(E value) {
    Node<E> node = new Node<>();
    node.value = value;

    if (last == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int index = 0;
    Node<E> node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    E old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = new Node<>();
    node.value = value;

    if (first == null) {
      first = last = node;

    } else if (index == 0) {
      node.next = first;
      first = node;

    } else if (index == size) {
      last.next = node;
      last = node;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> deleted = null;

    if (size == 1) {
      deleted = first;
      first = last = null;

    } else if (index == 0) {
      deleted = first;
      first = first.next;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      deleted = currNode.next;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }

    size--;

    E old = deleted.value;
    deleted.value = null;
    deleted.next = null;
    return old;
  }

  public boolean remove(E value) {
    Node prevNode = null;
    Node node = first;

    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }

    } else {
      prevNode.next = node.next;
    }

    size--;
    return true;
  }

  public E[] toArray(final E[] arr) {
    E[] values = arr;
    if (values.length < size) {
      values = Arrays.copyOf(arr, size);
    }

    int i = 0;
    Node<E> node = first;

    while (node != null) {
      values[i++] = node.value;
      node = node.next;
    }

    return values;
  }

  private static class Node<E> {
    E value;
    Node<E> next;
  }
}