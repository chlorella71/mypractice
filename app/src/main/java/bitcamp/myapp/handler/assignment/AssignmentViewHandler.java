package bitcamp.myapp.handler.assignment;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;

public class AssignmentViewHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentViewHandler (AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);

    int index = this.prompt.inputInt("번호? ");
    Assignment assignment = this.assignmentRepository.get(index);
    if (assignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("과제명: %s\n", assignment.title);
    System.out.printf("내용: %s\n", assignment.content);
    System.out.printf("제출 마감일: %s\n", assignment.deadline);
  }
}