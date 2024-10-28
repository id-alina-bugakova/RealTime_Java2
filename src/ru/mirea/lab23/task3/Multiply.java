package ru.mirea.lab23.task3;

public class Multiply extends BinaryOperation {
    public Multiply(Operable operand1, Operable operand2) {
        super(operand1, operand2);
    }

    @Override
    public double evaluate(double x0) {
        double op1 = 0, op2 = 0;
        if(this.operand1 instanceof Variable)
            op1 = x0;
        else if (this.operand1 instanceof Const)
            op1 = ((Const) this.operand1).getValue();
        else if (this.operand1 instanceof BinaryOperation)
            op1 = ((BinaryOperation) this.operand1).evaluate(x0);
        if(this.operand2 instanceof Variable)
            op2 = x0;
        else if (this.operand2 instanceof Const)
            op2 = ((Const) this.operand2).getValue();
        else if (this.operand2 instanceof BinaryOperation)
            op2 = ((BinaryOperation) this.operand2).evaluate(x0);
        return op1 * op2;
    }
}
