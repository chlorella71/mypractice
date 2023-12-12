package bitcamp.myapp.menu;

import bitcamp.util.Prompt;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;

public class AssignmentAddHandler implements MenuHandler{

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  @Override
  public void action(Menu menu) {
      System.out.println("과제 등록:");

      if (this.assignmentRepository.length == this.assignmentRepository.assignments.length) {
        int oldSize = this.assignmentRepository.assignments.length;
        int newSize = oldSize + (oldSize / 2);

        Assignment[] arr = new Assignment[newSize];
        for(int i = 0; i < oldSize; i++) {
          arr[i] = this.assignmentRepository.assignments[i];
        }

        this.assignmentRepository.assignments = arr;
      }

      Assignment assignment = new Assignment();
      assignment.title = this.prompt.input("과제명? ");
      assignment.content = this.prompt.input("내용? ");
      assignment.deadline = this.prompt.input("제출 마감일? ");

      this.assignmentRepository.assignments[this.assignmentRepository.length] = assignment;
      this.assignmentRepository.length++;

    }
  }
}