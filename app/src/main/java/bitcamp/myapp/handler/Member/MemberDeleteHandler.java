package bitcamp.myapp.handler.Member;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberDeleteHandler implements MenuHandler {

  Prompt prompt;

  MemberRepository memberRepository;

  public MemberDeleteHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);

    int index = this.prompt.inputInt("번호? ");
    if (this.memberRepository.remove(index) == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
    }
  }
}