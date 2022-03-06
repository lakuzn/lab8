import java.util.ArrayList;
import java.util.Scanner;

public class FractionExpression {

    private ArrayList<String> fractionExpressionString = new ArrayList<>();
    private Fraction fraction1;
    private Fraction fraction2;
    private String sign;

    public FractionExpression() {
        Scanner console = new Scanner(System.in);

        String fractionExpression = console.nextLine();
        String[] splitString = fractionExpression.split(" ");

        try {
            if (splitString.length != 3)
                throw new InvalidExpression();

        } catch (InvalidExpression invalidExpression) {
            invalidExpression.printStackTrace();
            System.err.println("Перезапустите программу и попробуйте ещё раз.");
            System.exit(1);

        }
        for (int i = 0; i < 3; i++) {
            fractionExpressionString.add(splitString[i]);
        }

        try {
            fraction1 = new Fraction(fractionExpressionString.get(0));
            fraction2 = new Fraction(fractionExpressionString.get(2));
            if (!(fractionExpressionString.get(1).equals("+") | fractionExpressionString.get(1).equals("-") | fractionExpressionString.get(1).equals("*") | fractionExpressionString.get(1).equals("/"))) {
                throw new InvalidExpression("Ошибка! Неверный знак. Используйте знаки: +, -, *, /");
            } else {
                sign = fractionExpressionString.get(1);
            }
        } catch (InvalidExpression e) {
            e.printStackTrace();
            System.err.println("Перезапустите программу и попробуйте ещё раз.");
            System.exit(1);
        }

        console.close();
        System.out.println("Ваш ответ: " + getAnswer());

    }

    private Fraction getAnswer() {

        Fraction answer = new Fraction();

        switch (sign) {

            case "+":
                answer = new Fraction(Fraction.sum(fraction1, fraction2));
                break;
            case "-":
                answer = new Fraction(Fraction.subtract(fraction1, fraction2));
                break;
            case "*":
                answer = new Fraction(Fraction.multiply(fraction1, fraction2));
                break;
            case "/":
                answer = new Fraction(Fraction.divide(fraction1, fraction2));
                break;
        }

        return answer;
    }


}