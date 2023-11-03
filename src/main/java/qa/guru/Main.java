package qa.guru;

public class Main {

    public static void main(String[] args) {
        logicOperation(5, 15);
        arithmeticOperation();
        combineOperation(30, 12);
    }

    private static void logicOperation(int a, int b) {
        System.out.println("\n");
        System.out.println(String.format("'a < b' %b", a < b));
        System.out.println(String.format("'a > b' %b", a > b));
        System.out.println(String.format("'a == b' %b", a == b));
        System.out.println(String.format("'a >= b' %b", a >= b));
        System.out.println(String.format("'a <= b' %b", a <= b));
        System.out.println(String.format("'a != b' %b", a != b));
        System.out.println(String.format("'true && false' %b", true && false));
        System.out.println(String.format("'true || false' %b", true || false));
    }

    private static void arithmeticOperation() {
        System.out.println("\n");
        int intPlus = Integer.MAX_VALUE + 2147483647;
        System.out.println(String.format("'сложение' %s", intPlus));
        byte byteMinus = (byte) (Byte.MAX_VALUE - 128);
        System.out.println(String.format("'вычитание' %s", byteMinus));
        short shortMultiply = (short) (Short.MAX_VALUE * 32768);
        System.out.println(String.format("'умножение' %s", shortMultiply));
        long longDivision = Long.MIN_VALUE / 999999999;
        System.out.println(String.format("'деление' %s", longDivision));
        float floatMod = 2.25f % 2;
        System.out.println(String.format("'остаток от деления' %s", floatMod));
    }

    private static void combineOperation(int a, double b) {
        System.out.println("\n");
        double doubleSum = a + b;
        System.out.println(doubleSum);
        double doubleMinus = a - b;
        System.out.println(doubleMinus);
        double doubleMultiply = a * b;
        System.out.println(doubleMultiply);
        double doubleDivision = a / b;
        System.out.println(doubleDivision);

        int intPlus = (int) (a + b);
        System.out.println(intPlus);
        int intMinus = (int) (a - b);
        System.out.println(intMinus);
        int intMultiply = (int) (a * b);
        System.out.println(intMultiply);
        int intDivision = (int) (a / b);
        System.out.println(intDivision);
    }
}
