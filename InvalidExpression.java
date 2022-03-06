public class InvalidExpression extends Exception {
    public InvalidExpression() {
        super("Ошибка ввода. Введите бесскобочное выражение вида: Дробь_*знак*_дробь");
    }

    public InvalidExpression(String errorMessage) {
        super(errorMessage);
    }
}