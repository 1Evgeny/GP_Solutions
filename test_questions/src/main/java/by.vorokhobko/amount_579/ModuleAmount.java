package by.vorokhobko.amount_579;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ModuleAmount.
 *
 * Class ModuleAmount is the solution of the problem № 579 https://acmp.ru/?main=task&id_task=579.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.01.2018.
 * @version 1.
 */
public class ModuleAmount {

    private void count(Scanner in, PrintWriter out) {
        int element = in.nextInt();
        int positive = 0;
        int negative = 0;
        int sumPositive = 0;
        int sumNegative = 0;
        for (int index = 0; index < element; index++) {
            int check = in.nextInt();
            if (check > 0) {
                positive++;
                sumPositive += check;
            } else if (check < 0) {
                negative++;
                sumNegative += check;
            }
        }
        in.close();
        try {
            in = new Scanner(new FileReader("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.nextInt();
        if (sumPositive > - sumNegative) {
            out.println(positive);
            for (int index = 1; index <= element; index++) {
                int result = in.nextInt();
                if (result > 0) {
                    out.print(index + " ");
                }
            }
        } else {
            out.println(negative);
            for (int index = 1; index <= element; index++) {
                int result = in.nextInt();
                if (result < 0) {
                    out.print(index + " ");
                }
            }
        }
    }

    private void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            count(in, out);
        }
    }

    public static void main(String[] args) {
        new ModuleAmount().run();
    }
}