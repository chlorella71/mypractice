package bitcamp.util;

import java.io.InputStream;
import java.sql.Date;
import java.util.Scanner;
public class Prompt {

  Scanner keyIn;

  public Prompt(InputStream in) {
    keyIn = new Scanner(in);
  }

  public String input(String title, Object... args) {
    System.out.printf(String.format(title, args));
    return this.keyIn.nextLine();
  }

  public int inputInt(String title, Object... args) {
    String str = this.input(title, args);
    return Integer.parseInt(str);
  }

  public float inputFloat(String title, Object... args) {
    String str = this.input(title, args);
    return Float.parseFloat(str);
  }

  public boolean inputBoolean(String title, Object... args) {
    String str = this.input(title, args);
    return Boolean.parseBoolean(str);
  }

  public Date inputDate(String title, Object... args) {
    return Date.valueOf((this.input(title, args)));
  }

  public void close() {
    this.keyIn.close();
  }
}