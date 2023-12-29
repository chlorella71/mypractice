package bitcamp.myapp.handler.board;

import bitcamp.util.List;
import java.util.Date;
import bitcamp.menu.AbstractMenuHandler;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardAddHandler extends AbstractMenuHandler {
  private List<Board> objectRepository;

  public BoardAddHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;

  }

  @Override
  protected void action() {
    try {
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    objectRepository.add(board);
  } catch (Exception e) {
      System.out.println("과제 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}