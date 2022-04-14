package KATYA;

import java.util.Scanner;

public class Main {
    public static String calc(String input) throws ScannerException {
        String[] split = input.split(" ");
        Calc calc = new Calc(split);
        return calc.getResult();
    }

    public static void main(String[] args) throws ScannerException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(calc(input));
    }
}
