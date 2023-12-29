package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;

public class BoardListHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;

  public BoardListHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-20s\t%-10s\t%s\n", "제목", "작성자", "작성일");

    Board[] boards = new Board[this.objectRepository.size()];
    this.objectRepository.toArray(boards);

    for(Board board : boards) {;
      System.out.printf("%-20s\t%-10s\t%s\n", board.getTitle(), board.getWriter(), board.getCreatedDate());
    }
  }
}