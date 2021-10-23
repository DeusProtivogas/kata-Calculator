import exceptions.*;


public class Calculator {
    public Object startCalculation(String line) throws IncorrectLengthException, IncorrectOperationException, DifferentNotationsException, NonPositiveRomanException, NumberTooLargeException, IncorrectSymbolException {

        String[] operands = InputChecker.check(line); // разделить ввод на операцию и операнды

        int a = 0, b = 0;

        boolean is_a_int = false, is_b_int = false;

        // проверки операндов: оба ли арабские, римские или нужно выбросить исключение
        try {
            a = Integer.parseInt(operands[0]);
            is_a_int = true; // операнд - арабское число
        } catch (NumberFormatException e) {
            for (int i = 0; i < operands[0].length(); i++) { // проверка на ввод недопустимых символов
                if (!( (operands[0].charAt(i) == 'I') || (operands[0].charAt(i) == 'V') || (operands[0].charAt(i) == 'X') )) {
                    throw new IncorrectSymbolException("Disallowed symbol on input");
                }
            } // если нет исключения, то операнд - римское число
        }
        try {
            b = Integer.parseInt(operands[2]);
            is_b_int = true;
        } catch (NumberFormatException e) {
            for (int i = 0; i < operands[2].length(); i++) {
                if (!( (operands[2].charAt(i) == 'I') || (operands[2].charAt(i) == 'V') || (operands[2].charAt(i) == 'X') )) {
                    throw new IncorrectSymbolException("Disallowed symbol on input");
                }
            }
        }

        if (is_a_int && is_b_int) { // операция с арабскими числами
            if ( (a > 10 || a < 1) || (b > 10 || b < 1)) { // проверка арабских чисел на величину на входе
                throw new NumberTooLargeException("Arabic number too large or too small");
            }

            return calculate(a, operands[1], b);
        }
        else if (!is_a_int && !is_b_int) { // операция с римскими числами
            return romanCalculate(operands[0], operands[1], operands[2]);
        }
        else { // несовместимые системы счиления
            throw new DifferentNotationsException("Conflicting notations");
        }
    }

    // вычисление для римских чисел
    public String romanCalculate(String a, String operation, String b) throws NonPositiveRomanException, NumberTooLargeException, IncorrectSymbolException {
        int A = RomanNumbers.RomanToInt(a); // перевод чисел из римской системы счиления в арабскую
        int B = RomanNumbers.RomanToInt(b);

        int C = calculate(A, operation, B);

        if (C <= 0) {
            throw new NonPositiveRomanException("Result is non-positive roman number");
        }

        String res = RomanNumbers.IntToRoman(C);

        return res;
    }

    // вычисление для арабских чисел
    public int calculate(int a, String operation, int b){

        int c = 0;

        switch (operation){
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
        }

        return c;
    }
}
