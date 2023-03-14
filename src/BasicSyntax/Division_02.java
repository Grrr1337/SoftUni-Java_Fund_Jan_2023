package BasicSyntax;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Division_02 {

    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);

        if (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scn.close();
            return;
        }

        int number = Integer.parseInt(scn.nextLine());

        if (number % 10 == 0) {
            System.out.println("The number is divisible by 10");
        }
        else if (number % 7 == 0) {
            System.out.println("The number is divisible by 7");
        }
        else if (number % 6 == 0) {
            System.out.println("The number is divisible by 6");
        }
        else if (number % 3 == 0) {
            System.out.println("The number is divisible by 3");
        } else if (number % 2 == 0) {
            System.out.println("The number is divisible by 2");
        } else {
            System.out.println("Not divisible");
        }

        scn.close();
    }// void main
}

