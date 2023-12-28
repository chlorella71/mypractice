package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberAddHandler extends AbstractMenuHandler {
  private ArrayList<Member> objectRepository;

  public MemberAddHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setName(this.prompt.input("이름? "));
    member.setEmail(this.prompt.input("이메일? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(this.prompt.input("가입일? "));

    this.objectRepository.add(member);
  }
}