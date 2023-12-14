package bitcamp.myapp.handler.Member;

import bitcamp.util.AnsiEscape;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberAddHandler implements MenuHandler {

  Prompt prompt;

  MemberRepository memberRepository;

  public MemberAddHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR);

    Member member = new Member();
    member.name = this.prompt.input("이름? ");
    member.email = this.prompt.input("이메일? ");
    member.password = this.prompt.input("암호? ");
    member.createdDate = this.prompt.input("가입일? ");

    this.memberRepository.add(member);
  }
}