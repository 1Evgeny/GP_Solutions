package by.vorokhobko.matrices_557;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Matrice.
 *
 * Class Matrice is the solution of the problem № 557 https://acmp.ru/?main=task&id_task=557.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.01.2018.
 * @version 1.
 */
public class Matrice {

    private void calculationMatrix(Scanner in, PrintWriter out)  {
        String firstLine = in.nextLine();
        String secondLine = in.nextLine();
        String thirdLine = in.nextLine();
        String[] numberAndSize = firstLine.split(" ");
        int m = Integer.parseInt(numberAndSize[0]);
        int n = Integer.parseInt(numberAndSize[1]);
        String[] lineNumberAndColumn = secondLine.split(" ");
        int line = Integer.parseInt(lineNumberAndColumn[0]);
        int column = Integer.parseInt(lineNumberAndColumn[1]);
        int p = Integer.parseInt(thirdLine);

        int[][][] allMatrix = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String insert = in.nextLine();
                if (insert.isEmpty()) {
                    insert = in.nextLine();
                }
                String[] elements = insert.split(" ");
                for (int k = 0; k < n; k++) {
                    allMatrix[i][j][k] = Integer.parseInt(elements[k]);
                }
            }
        }

        int[] resultLine = allMatrix[0][line - 1];
        for (int i = 1; i < m; i++) {
            resultLine = mult(resultLine, allMatrix[i], n, p);
        }
        out.println(resultLine[column - 1]);
    }

    private static int[] mult(int[] x, int[][] y, int n, int p) {
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += x[j] * y[j][i];
            }
            if (result[i] > p) {
                result[i] = result[i] % p;
            }
        }
        return result;
    }

    private void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            calculationMatrix(in, out);
        }
    }

    public static void main(String[] args) {
        new Matrice().run();
    }
}