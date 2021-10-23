import exceptions.NumberTooLargeException;

public class RomanNumbers {
    // перевод из римской системы счисления в арабскую
    public static int RomanToInt(String num) throws NumberTooLargeException {

        int res = num.replaceAll("IV", "IIII")
                .replaceAll("IX", "VIIII")
                .replaceAll("X", "VV")
                .replaceAll("V", "IIIII")
                .length();

        if (res > 10 || res < 1) {
            throw new NumberTooLargeException("Roman number too large or too small");
        }

        return res;
    }

    // перевод из арабской системы счисления в римскую
    public static String IntToRoman(int num){

        String res = "";
        for (int i = 0; i < num; i++){
            res += "I";
        }

        return res.replaceAll("IIIII", "V")
                .replaceAll("IIII", "IV")
                .replaceAll("VV", "X")
                .replaceAll("VIV", "IX")
                .replaceAll("XXXXX", "L")
                .replaceAll("XXXX", "XL")
                .replaceAll("LL", "C")
                .replace("LXL", "XC");

    }
}
