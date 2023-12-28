package bitcamp.menu;

import bitcamp.util.Prompt;
public class MenuItem extends AbstractMenu{

  MenuHandler menuHandler;

  public MenuItem(String title) {
    super(title);
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action(this);
    }
  }
}