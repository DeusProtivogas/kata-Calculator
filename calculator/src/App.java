import exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException, IncorrectLengthException, IncorrectOperationException, DifferentNotationsException, NonPositiveRomanException, NumberTooLargeException, IncorrectSymbolException {

        Calculator calc = new Calculator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(calc.startCalculation(reader.readLine()));
    }
}
