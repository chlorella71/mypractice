package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardModifyHandler extends AbstractMenuHandler {
  private List<Board> objectRepository;

  public BoardModifyHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      Board oldBoard = (Board) this.objectRepository.get(index);
      Board board = new Board();
      board.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(this.prompt.inputDate("작성일(%s)? ", oldBoard.getCreatedDate()));

      this.objectRepository.set(index, board);
    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IndexOutOfBoundsException e) {
      System.out.println("과제 번호가 유효하지 않습니다.");

    } catch (IllegalArgumentException e) {
      System.out.println("과제 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
    }
  }
}