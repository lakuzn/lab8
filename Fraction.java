public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(Fraction fraction) {
        this.numerator = fraction.getnumerator();
        this.denominator = fraction.getdenominator();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        shorten();
    }

    public Fraction(String fraction) throws InvalidExpression {
        String[] fractionString = fraction.split("/");

        if (fractionString.length != 2) {
            throw new InvalidExpression("Ошибка! Введите дробь вида *числитель*/*знаменатель*");
        }
        try {
            numerator = Integer.parseInt(fractionString[0]);
            denominator = Integer.parseInt(fractionString[1]);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка. В числителе и знаменателе вводите числа, конвертируемые в целые.");
            System.err.println("Перезапустите программу и попробуйте ещё раз.");
            System.exit(2);
        }

    }

    public static Fraction sum(Fraction f1, Fraction f2) {
        int num;
        int denom;

        if (f1.denominator != f2.denominator) {
            denom = f1.denominator * f2.denominator;
            num = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        } else {
            denom = f1.denominator;
            num = f1.numerator + f2.numerator;
        }
        Fraction f3 = new Fraction(num, denom);
        return f3;
    }

    public static Fraction subtract(Fraction f1, Fraction f2) {
        int num;
        int denom;

        if (f1.denominator != f2.denominator) {
            denom = f1.denominator * f2.denominator;
            num = f1.numerator * f2.denominator - f2.numerator * f1.denominator;
        } else {
            denom = f1.denominator;
            num = f1.numerator - f2.numerator;
        }
        Fraction f3 = new Fraction(num, denom);
        return f3;
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getnumerator() * f2.getnumerator(), f1.getdenominator() * f2.getdenominator());
        return f3;
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f1.getnumerator() * f2.getdenominator(), f1.getdenominator() * f2.getnumerator());
        return f3;
    }

    public int getdenominator() {
        return denominator;
    }

    public int getnumerator() {
        return numerator;
    }

    private void shorten() {
        if (numerator * denominator < 0) {
            numerator = -1 * Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (numerator * denominator > 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (numerator == 0) {
            denominator = 1;
        } else {
            System.err.println("Ошибка деления на ноль.");
        }
        if (numerator >= denominator) {
            for (int i = numerator; i > 0; i--) {
                if (numerator % i == 0 & denominator % i == 0) {
                    numerator = numerator / i;
                    denominator = denominator / i;
                }
            }
        } else {
            for (int i = denominator; i > 0; i--) {
                if (numerator % i == 0 & denominator % i == 0) {
                    numerator = numerator / i;
                    denominator = denominator / i;
                }
            }
        }
    }

    public void sum(Fraction f2) {
        if (denominator != f2.denominator) {
            numerator = numerator * f2.denominator + f2.numerator * denominator;
            denominator = denominator * f2.denominator;
        } else {
            numerator = numerator + f2.numerator;
        }
    }

    public void subtract(Fraction f2) {
        if (denominator != f2.denominator) {
            numerator = numerator * f2.denominator - f2.numerator * denominator;
            denominator = denominator * f2.denominator;
        } else {
            numerator = numerator - f2.numerator;
        }

    }

    public void multiply(Fraction f2) {
        int num = numerator * f2.numerator;
        int denom = denominator * f2.denominator;
        numerator = num;
        denominator = denom;
    }

    public void divide(Fraction f2) {
        int num = numerator * f2.denominator;
        int denom = denominator * f2.numerator;
        numerator = num;
        denominator = denom;
    }

    public String toString() {
        shorten();
        return (numerator + "/" + denominator);
    }
}