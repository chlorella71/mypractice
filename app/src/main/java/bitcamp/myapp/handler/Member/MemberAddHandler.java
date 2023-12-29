package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {
  private List<Member> objectRepository;

  public MemberAddHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
    Member member = new Member();
    member.setName(this.prompt.input("이름? "));
    member.setEmail(this.prompt.input("이메일? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(new Date());

    this.objectRepository.add(member);

  } catch (Exception e) {
      System.out.println("과제 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}