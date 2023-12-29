package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;

  public BoardDeleteHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;

  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      this.objectRepository.remove(index);

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}