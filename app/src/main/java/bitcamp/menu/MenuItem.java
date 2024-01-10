package bitcamp.menu;


import bitcamp.util.Prompt;
import bitcamp.util.Stack;

public class MenuItem extends AbstractMenu{

  private MenuHandler menuHandler;

  public MenuItem(String title, bitcamp.util.Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  public MenuItem(String title, Stack<String> breadcrumb, MenuHandler menuHandler) {
    this(title, breadcrumb);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      try {
        this.menuHandler.action(this);
      } catch (Exception e) {
        System.out.println("실행 오류!");
      }
    }
  }
}