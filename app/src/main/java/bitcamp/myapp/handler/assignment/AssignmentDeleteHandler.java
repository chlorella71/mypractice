package bitcamp.myapp.handler.assignment;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.Menu;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;
import bitcamp.menu.MenuHandler;
public class AssignmentDeleteHandler implements MenuHandler{

  Prompt prompt;
  ObjectRepository objectRepository;

  public AssignmentDeleteHandler(ObjectRepository objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);

    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    }
  }

}