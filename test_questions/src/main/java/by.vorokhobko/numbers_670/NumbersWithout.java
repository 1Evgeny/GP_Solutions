package by.vorokhobko.numbers_670;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersWithout {

    private void repeatingNumber(Scanner in, PrintWriter out) {
        String number;
        String s = in.next();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i = 0; i < 10000; i++) {
            number = i.toString();
            if (number.length() == 1) {
                result.add(i);
            } else if (number.length() == 2 && number.charAt(0) != number.charAt(1)) {
                result.add(i);
            } else if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                result.add(i);
            } else if (number.length() == 4 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(2) != number.charAt(3)
                    && number.charAt(0) != number.charAt(2)
                    && number.charAt(0) != number.charAt(3)
                    && number.charAt(1) != number.charAt(3)) {
                result.add(i);
            }
        }
        out.println(result.get(Integer.parseInt(s)));
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
