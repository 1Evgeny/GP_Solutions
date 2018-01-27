package by.vorokhobko.biology_278;

import java.io.*;
import java.util.Scanner;

/**
 * ComputationalBiology.
 *
 * Class ComputationalBiology is the solution of the problem № 278 https://acmp.ru/?main=task&id_task=278.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.01.2018.
 * @version 1.
 */
public class ComputationalBiology {

    private void decision(Scanner in, PrintWriter out) {
        String firstLine = in.next();
        String secondLine = in.next();
        int position = 0;
        for (int index = 0; index < secondLine.length(); index++) {
            if ((firstLine.charAt(position)) == secondLine.charAt(index)) {
                position++;
                if (position == firstLine.length()) {
                    out.println("Yes");
                    return;
                }
            }
        }
        out.println("No");
    }

    public void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            decision(in, out);
        }
    }

    public static void main(String[] args) {
        new ComputationalBiology().run();
    }
}