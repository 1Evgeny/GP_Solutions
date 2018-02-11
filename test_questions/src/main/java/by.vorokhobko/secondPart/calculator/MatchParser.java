package by.vorokhobko.secondPart.calculator;

import java.util.HashMap;

/**
 * MatchParser.
 *
 * Class MatchParser is class for parsing elements in String line.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.02.2018.
 * @version 1.
 */
public class MatchParser {
    /**
     * The class field.
     */
    private HashMap<String, Double> variables;
    /**
     * Add constructor.
     */
    public MatchParser() {
        variables = new HashMap<>();
    }
    /**
     * Method parse element in program.
     * @param element - element.
     * @throws Exception tag.
     */
    public double parse(String element) throws Exception {
        Result result = plusMinus(element);
        if (!result.getLine().isEmpty()) {
            System.err.println("Error: can't full parse");
            System.err.println("rest: " + result.getLine());
        }
        return result.getNumber();
    }
    /**
     * Method counts result plus and minus in program.
     * @param element - element.
     * @throws Exception tag.
     */
    private Result plusMinus(String element) throws Exception {
        Result current = mulDiv(element);
        double acc = current.getNumber();
        while (current.getLine().length() > 0) {
            if (!(current.getLine().charAt(0) == '+' || current.getLine().charAt(0) == '-')) {
                break;
            }
            char sign = current.getLine().charAt(0);
            String next = current.getLine().substring(1);
            current = mulDiv(next);
            if (sign == '+') {
                acc += current.getNumber();
            } else {
                acc -= current.getNumber();
            }
        }
        return new Result(acc, current.getLine());
    }
    /**
     * Method show brackets in program.
     * @param element - element.
     * @throws Exception tag.
     */
    private Result bracket(String element) throws Exception {
        char zeroChar = element.charAt(0);
        if (zeroChar == '(') {
            Result r = plusMinus(element.substring(1));
            if (!r.getLine().isEmpty() && r.getLine().charAt(0) == ')') {
                r.setLine(r.getLine().substring(1));
            } else {
                System.err.println("Error: not close bracket");
            }
            return r;
        }
        return num(element);
    }
    /**
     * Method counts result multiplication and division in program.
     * @param element - element.
     * @throws Exception tag.
     */
    private Result mulDiv(String element) throws Exception {
        Result current = sqrt(element);
        double acc = current.getNumber();
        while (true) {
            if (current.getLine().length() == 0) {
                return current;
            }
            char sign = current.getLine().charAt(0);
            if ((sign != '*' && sign != '/')) {
                return current;
            }
            String next = current.getLine().substring(1);
            Result right = sqrt(next);
            if (sign == '*') {
                acc *= right.getNumber();
            } else {
                acc /= right.getNumber();
            }

            current = new Result(acc, right.getLine());
        }
    }
    /**
     * Method counts result sqrt in program.
     * @param element - element.
     * @throws Exception tag.
     */
    private Result sqrt(String element) throws Exception {
        Result current = bracket(element);
        double acc = current.getNumber();
        while (true) {
            if (current.getLine().length() == 0) {
                return current;
            }
            char sign = current.getLine().charAt(0);
            if (sign != '^') {
                return current;
            }
            String next = current.getLine().substring(1);
            Result right = bracket(next);
            acc = Math.pow(acc, right.getNumber());
            current = new Result(acc, right.getLine());
        }
    }
    /**
     * Method shows number in program.
     * @param element - element.
     * @throws Exception tag.
     */
    private Result num(String element) throws Exception {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
        if (element.charAt(0) == '-') {
            negative = true;
            element = element.substring( 1 );
        }
        while (i < element.length() && (Character.isDigit(element.charAt(i)) || element.charAt(i) == '.')) {
            if (element.charAt(i) == '.' && element.charAt(i) == ',' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + element.substring(0, i + 1) + "'");
            }
            i++;
        }
        if (i == 0 ) {
            throw new Exception( "can't get valid number in '" + element + "'" );
        }
        double dPart = Double.parseDouble(element.substring(0, i));
        if (negative) dPart = -dPart;
        String restPart = element.substring(i);
        return new Result(dPart, restPart);
    }
}