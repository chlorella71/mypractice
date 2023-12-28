package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardModifyHandler extends AbstractMenuHandler {
  private ArrayList<Board> objectRepository;

  public BoardModifyHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    Board oldBoard = (Board) this.objectRepository.get(index);
    if (oldBoard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = new Board();
    board.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
    board.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
    board.setCreatedDate(this.prompt.input("작성일(%s)? ", oldBoard.getCreatedDate()));

    this.objectRepository.set(index, board);
  }
}