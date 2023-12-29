package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;

public class MemberListHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberListHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

    Member[] members = new Member[this.objectRepository.size()];
    this.objectRepository.toArray(members);

    for (Member member : members) {
      System.out.printf("%-20s\t%30s\t%s\n", member.getName(), member.getEmail(), member.getCreatedDate());
    }
  }
}