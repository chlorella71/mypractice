package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import bitcamp.menu.MenuHandler;
public class AssignmentListHandler implements MenuHandler{

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.println("과제 목록:");
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    for (int i = 0; i < this.assignmentRepository.length; i++) {
      Assignment assignment = this.assignmentRepository.assignments[i];
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}