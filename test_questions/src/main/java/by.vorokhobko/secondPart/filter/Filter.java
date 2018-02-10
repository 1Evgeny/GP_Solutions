package by.vorokhobko.secondPart.filter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Filter.
 *
 * Class Filter is designed for matching in program.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 10.02.2018.
 * @version 1.
 */
public class Filter {
    /**
     * The class field.
     */
    private ArrayList<String> list = new ArrayList<>();
    /**
     * The class field.
     */
    private ArrayList<String> result = new ArrayList<>();
    /**
     * The class field.
     */
    private Pattern pattern;
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        new Filter().start();
    }
    /**
     * The method start is method for starting program.
     */
    private void start() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            electoralMethod(in, out);
        }
    }
    /**
     * Method adds argument in the program.
     * @param in - in.
     */
    private void addArgument(Scanner in) {
        System.out.println("Please enter the argument: ");
        String textFirst = in.nextLine();
        String[] firstLine = textFirst.split(" ");
        String findElement = "";
        if (firstLine.length > 1) {
            for (String count : firstLine) {
                findElement += count.concat("|");
            }
            textFirst = findElement;
        }
        this.pattern = Pattern.compile(textFirst);
    }
    /**
     * Method adds string in the program.
     * @param in - in.
     */
    private void addCompareString(Scanner in) {
        System.out.println("Please enter a string for comparison: ");
        while (true) {
            String textSecond = in.nextLine();
            if (textSecond.isEmpty()) {
                break;
            }
            this.list.add(textSecond);
        }
    }
    /**
     * Method compares String elements in the program.
     * @param search - search.
     */
    private boolean compare(String search) {
        return this.pattern.matcher(search).matches();
    }
    /**
     * Method electoral element in the program.
     * @param in - in.
     * @param out - out.
     */
    private void electoralMethod(Scanner in, PrintWriter out) {
        addArgument(in);
        addCompareString(in);
        System.out.println("Result: ");
        for (String element : this.list) {
            for (int j = 0; j < element.split(" ").length; j++) {
                String result = element.split(" ")[j].replace(";", "");
                if (compare(result)) {
                    this.result.add(element);
                    break;
                }
            }
        }
        printResult(out);
    }
    /**
     * Method print all element users.
     * @param out - out.
     */
    private void printResult(PrintWriter out) {
        for (String line : this.result) {
            out.println(line);
        }
        if (this.result.size() == 0) {
            out.println("No matches in rows!");
        }
    }
}