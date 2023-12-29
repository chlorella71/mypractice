package bitcamp.myapp.handler.Member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.List;
import java.util.ArrayList;
import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberDeleteHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      this.objectRepository.remove(index);

    } catch (Exception e) {
    System.out.println("회원 번호가 유효하지 않습니다.");
    }
  }
}