package by.vorokhobko.secondPart.calculator;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Calculator.
 *
 * Class Calculate the solution second part test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 08.02.2016.
 * @version 3.
 */
public class Calculator {

    private void calculate(Scanner in, PrintWriter out) {
        Pattern pattern = Pattern.compile("[^0-9^+\\-*/(),.\\s]|\\d\\s\\d");
        System.out.println("Please enter String element: ");
        String line = in.nextLine();
        if (!pattern.matcher(line).find()) {
            line = line.replace(" ", "").replace(",", ".");
            MatchParser matchParser = new MatchParser();
            try {
                out.println("Result: " + matchParser.parse(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            out.println("You can enter invalid element!");
        }
    }

    private void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            calculate(in, out);
        }
    }

    public static void main(String[] args) {
        new Calculator().run();
    }
}