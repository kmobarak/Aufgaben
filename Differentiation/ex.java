import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

import static aud.example.expr.AtomicExpression.Type.OpPlus;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
 `ExpressionTree` with respect to a user specified variable.*/
import aud.example.expr.*;

public class ex {
    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
        AtomicExpression current = t.getData();

        if (current.toString().equals(var)) {
            return new ExpressionTree(new Number(1));
        }

        if (current.getType() == AtomicExpression.Type.TNumber || current.getType() == AtomicExpression.Type.TSymbol) {
            return new ExpressionTree(new Number(0));
        }

        if (current.isOperator()) {
            ExpressionTree left = differentiate(t.getLeft(), var);
            ExpressionTree right = differentiate(t.getRight(), var);

            if (current.getType() == AtomicExpression.Type.OpUnaryMinus) {
                return new ExpressionTree(new UnaryMinus(), left, right);
            }

            if (current.getType() == AtomicExpression.Type.OpPlus) {
                return new ExpressionTree(new Plus(), left, right);
            } else if (current.getType() == AtomicExpression.Type.OpMinus) {
                return new ExpressionTree(new Minus(), left, right);
            } else if (current.getType() == AtomicExpression.Type.OpTimes) {
                ExpressionTree derivativeLeftTimesRight = new ExpressionTree(new Times(), left, right);
                ExpressionTree derivativeRightTimesLeft = new ExpressionTree(new Times(), right, left);
                return new ExpressionTree(new Plus(), derivativeLeftTimesRight, derivativeRightTimesLeft);
            }
        }

        return new ExpressionTree(new Number(0));
    }

    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
    }
}
