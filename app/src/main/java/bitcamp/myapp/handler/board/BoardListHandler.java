package bitcamp.myapp.handler.board;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardListHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardListHandler(BoardRepository boardRepository, Prompt prompt) {
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);
    System.out.printf("%-20s\t%-10s\t%s\n", "제목", "작성자", "작성일");

    for(Board board : boardRepository.toArray()) {
      System.out.printf("%-20s\t%-10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}