package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentAddHandler (ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;

  }

  @Override
  protected void action() {
  Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("과제명? "));
    assignment.setContent(this.prompt.input("내용? "));
    assignment.setDeadline(this.prompt.input("제출 마감일? "));

    this.objectRepository.add(assignment);
  }
}