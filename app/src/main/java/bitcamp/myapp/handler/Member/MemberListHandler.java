package bitcamp.myapp.handler.Member;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberListHandler implements MenuHandler {

  Prompt prompt;

  MemberRepository memberRepository;

  public MemberListHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);
    System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

    for (Member member : this.memberRepository.toArray()) {
      System.out.printf("%-20s\t%30s\t%s\n", member.name, member.email, member.createdDate);
    }
  }
}