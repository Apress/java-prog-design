package javaprogramdesign.chapter05.bank14;

import java.util.Scanner;

public interface InputCommand {
   int execute(Scanner sc, Bank bank, int current);
}
