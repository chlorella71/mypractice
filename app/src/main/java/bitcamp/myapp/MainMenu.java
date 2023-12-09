package bitcamp.myapp;

public class MainMenu {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APPTITLE = "[과제관리 시스템]";
  static final String[] MENUS = {
    "1. 과제",
    "2. 게시글",
    "3. 도움말",
    ANSI_RED + "4. 종료" + ANSI_CLEAR
  };

  static void printMenu() {
    System.out.println(ANSI_BOLD_RED + APPTITLE + ANSI_CLEAR);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  static void mainMenu() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인> ");

      switch (input) {
        case "1":
          AssignmentMenu.execute();
          break;
        case "2":
          BoardMenu.execute();
          break;
        case "3":
          System.out.println("도움밀압니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          return;
        case "menu":
          System.out.println(ANSI_BOLD_RED + APPTITLE + ANSI_CLEAR);
          System.out.println();
          for (String menu : MENUS) {
            System.out.println(menu);
          }
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}