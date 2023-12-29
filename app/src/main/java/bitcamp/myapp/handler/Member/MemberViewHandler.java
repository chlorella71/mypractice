package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberViewHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
    int index = this.prompt.inputInt("번호? ");
    Member member = (Member) this.objectRepository.get(index);
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("가입일: %s\n", member.getCreatedDate());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }
}