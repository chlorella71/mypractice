package bitcamp.menu;

import bitcamp.util.LinkedList;
import bitcamp.util.List;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import bitcamp.util.Stack;

public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();

  private MenuGroup(String title, Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  public static MenuGroup getInstance(String title) {
    return new MenuGroup(title, new Stack<String>());
  }

  @Override
  public void execute(Prompt prompt) {
    breadcrumb.push(this.title);
    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.getTitle());

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      try {
        int menuN0 = Integer.parseInt(input);
        if (menuN0 < 1 || menuN0 > this.menus.size()) {
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }

        this.menus.get(menuN0 - 1).execute(prompt);
      } catch (Exception e) {
        System.out.println("메뉴가 옳지 않습니다!");
      }
    }
    breadcrumb.pop();
  }

  private void printMenu() {
      System.out.printf("[%s]\n", this.getTitle());

      for (int i = 0; i < this.menus.size(); i++) {
        System.out.printf("%d. %s\n", (i + 1), menus.get(i).getTitle());
      }

      System.out.printf("0. %s\n", "이전");
    }
  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public MenuItem addItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, this.breadcrumb, handler);
    this.add(menuItem);
    return menuItem;
  }

  public MenuGroup addGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title, this.breadcrumb);
    this.add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }
}