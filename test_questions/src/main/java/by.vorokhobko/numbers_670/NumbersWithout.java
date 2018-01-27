package by.vorokhobko.numbers_670;

import java.io.PrintWriter;
import java.util.Scanner;

public class NumbersWithout {

    private void repeatingNumber(Scanner in, PrintWriter out) {
        int num = 12345618;
        boolean have = false;
        int array[] = new int[(int)Math.log10(num)+1];
        for(int i = 0; i < array.length; i++) {
            array[i] = num%10;
            num/=10;
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++)
                if(array[i] == array[j] && i != j) {
                    System.out.print(array[i] + " ");
                    have = true;
                }
        }
        if(!have) System.out.println("Повторяющихся цифр не обнаружено!");
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
