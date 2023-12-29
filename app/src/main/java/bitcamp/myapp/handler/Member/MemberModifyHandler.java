package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberModifyHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      Member old = (Member) this.objectRepository.get(index);
      Member member = new Member();
      member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
      member.setName(this.prompt.input("이름(%s)? ", old.getName()));
      member.setPassword(this.prompt.input("새 암호?"));
      member.setCreatedDate(this.prompt.inputDate("가입일(%s) ?", old.getCreatedDate()));

      this.objectRepository.set(index, member);

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