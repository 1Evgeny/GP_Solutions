package by.vorokhobko.secondPart.calculator;

/**
 * Result.
 *
 * Class Result is the class elements in the program.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.02.2018.
 * @version 1.
 */
public class Result {
    /**
     * The class field.
     */
    private double number;
    /**
     * The class field.
     */
    private String line;
    /**
     * Add constructor.
     * @param element - element.
     * @param line - line.
     */
    public Result(double element, String line) {
        this.number = element;
        this.line = line;
    }
    /**
     * Add setter Line.
     * @param line - line.
     */
    public void setLine(String line) {
        this.line = line;
    }
    /**
     * Add getter Number.
     * @return tag.
     */
    public double getNumber() {
        return number;
    }
    /**
     * Add getter Line.
     * @return tag.
     */
    public String getLine() {
        return line;
    }
}