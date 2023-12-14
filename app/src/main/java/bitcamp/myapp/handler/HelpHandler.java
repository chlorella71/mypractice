package bitcamp.myapp.handler;

import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.util.AnsiEscape;

public class HelpHandler implements MenuHandler {

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);
    System.out.println("도움말입니다.");
  }
}