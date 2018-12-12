package javaprogramdesign.chapter11.bank19;

import java.util.Scanner;

public interface InputCommand {
   String execute(Scanner sc, InputController controller);
}
