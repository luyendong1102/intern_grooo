public class Main {
    public static void main(String[] args) {
        ArithmeticOperator operator = new AddOperator();
        System.out.println("5 + 5 = " + operator.doOperator(5,5));
        operator = new MultiplyOperator();
        System.out.println("5 * 5 = " + operator.doOperator(5,5));
    }
}
