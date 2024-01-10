package bitcamp.myapp.handler;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.util.AnsiEscape;

public class HelpHandler extends AbstractMenuHandler {

  public HelpHandler(Prompt prompt) {
    super(prompt);
  }

  @Override
  public void action() {
    System.out.println("도움말입니다.");
  }
}