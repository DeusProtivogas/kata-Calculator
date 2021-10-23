import exceptions.*;

public class InputChecker {
    public static String[] check(String line) throws IncorrectLengthException, IncorrectOperationException {
        String[] operands = line.split(" ");
        if (operands.length != 3) { // проверка на длину ввода
            throw new IncorrectLengthException("Incorrect number of elements");
        }

        String operations = "+-*/"; // проверка на недопустимый символ операции
        if (!operations.contains(operands[1])) {
            throw new IncorrectOperationException("Incorrect operation");
        }

        return operands;
    }
}
