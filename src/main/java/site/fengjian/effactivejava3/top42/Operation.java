package site.fengjian.effactivejava3.top42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op){
        this.op = op;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args) {

        System.out.println(Operation.PLUS.apply(1, 2));
    }
}
