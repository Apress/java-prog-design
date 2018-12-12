package javaprogramdesign.chapter05.bank12;

import java.util.Scanner;

public interface InputCommand {
   int execute(Scanner sc, Bank bank, int current);
}
