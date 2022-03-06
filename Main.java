import java.util.Scanner;

public class Main {
    public static int Input() {
        Scanner console = new Scanner(System.in);
        int input = 0;
        while (true) {
            if (console.hasNextInt()) {
                input = console.nextInt();
                break;
            } else {
                System.out.println("Ошибка ввода. Вводите только целые числа.");
                console.next();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        FractionExpression myExpression = new FractionExpression();
    }
}