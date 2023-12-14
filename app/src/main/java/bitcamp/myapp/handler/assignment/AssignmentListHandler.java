package bitcamp.myapp.handler.assignment;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;
import bitcamp.menu.MenuHandler;
public class AssignmentListHandler implements MenuHandler{

  ObjectRepository objectRepository;

  public AssignmentListHandler(ObjectRepository objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    for (Object object : this.objectRepository.toArray()) {
      Assignment assignment = (Assignment) object;
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}