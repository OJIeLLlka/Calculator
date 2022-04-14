package KATYA;

import java.util.HashMap;
import java.util.Map;

class Calc {
    final static Map<String, Integer> arabRoman = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    final static String[] romanArray = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final int[] arabDigit = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romeDigit = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    protected int a = 0, b = 0, result;

    public Calc (String[] input) throws ScannerException {
        fill();
        isArabicOrRoman(input);
    }

    public void fill() {
        for (int i = 0; i < romanArray.length; i++) {
            arabRoman.put(romanArray[i], i+1);
        }
    }

    public void isArabicOrRoman(String[] input) throws ScannerException {
        if (input.length > 3) {
            throw new ScannerException("Neverniy format vvoda");
        } else if (arabRoman.containsKey(input[0]) && arabRoman.containsKey(input[2])) {
            a = arabRoman.get(input[0]);
            b = arabRoman.get(input[2]);
            arabToRoman(Math.abs(calculate(input)));
        } else if (arabRoman.containsValue(Integer.parseInt(input[0])) && arabRoman.containsValue(Integer.parseInt(input[2]))) {
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[2]);
            sb.append(calculate(input));
        } else {
            throw new ScannerException("Neverniy format vvoda");
        }
    }

    public void arabToRoman(int r) throws ScannerException {
        if (result < 1) {
            throw new ScannerException("nety Rimskih chisel < 1 :<");
        }

        for (int i = 0; i < arabDigit.length; i++) {
            while ((r - arabDigit[i]) >= 0) {
                r -= arabDigit[i];
                sb.append(romeDigit[i]);
            }
        }
    }

    public String getResult() {
        String res = String.valueOf(sb);
        return res;
    }

    public int calculate(String[] split) throws ScannerException {
        switch (split[1]) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
            default:
                throw new ScannerException("Neverniy format vvoda.");
        }
        return result;
    }
}





