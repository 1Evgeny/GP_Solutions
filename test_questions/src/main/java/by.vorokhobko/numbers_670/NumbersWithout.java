package by.vorokhobko.numbers_670;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * NumbersWithout.
 *
 * Class NumbersWithout is the solution of the problem № 670 https://acmp.ru/?main=task&id_task=670.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.01.2018.
 * @version 1.
 */
public class NumbersWithout {

    private void repeatingNumber(Scanner in, PrintWriter out) {
        int g = in.nextInt();
        int index = 0;
        int position = 1;
        for (; index < g; position++) {
            if (check(position))
                index++;
        }
        out.println(position - 1);
    }

    private boolean check(int element) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean isNeedSave = true;
        while (element != 0) {
            int count = element % 10;
            if (!result.contains(count)) {
                result.add(count);
            } else {
                isNeedSave = false;
            }
            element = element / 10;
        }
        return isNeedSave;
    }

    public void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            repeatingNumber(in, out);
        }
    }

    public static void main(String[] args) {
        new NumbersWithout().run();
    }
}