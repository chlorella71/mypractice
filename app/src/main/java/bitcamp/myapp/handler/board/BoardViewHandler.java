package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardViewHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;

  public BoardViewHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
    int index = this.prompt.inputInt("번호? ");
    Board board = (Board) this.objectRepository.get(index);
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }
}