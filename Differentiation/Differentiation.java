import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
 `ExpressionTree` with respect to a user specified variable.*/
public class Differentiation {
    //----------------------------------------------------------------//
    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
        AtomicExpression current = t.getData();

        if (current.toString().equals(var)) {
            return new ExpressionTree(new Number(1));
        }

        if (current.getType() == AtomicExpression.Type.TNumber || current.getType() == AtomicExpression.Type.TSymbol) {
            return new ExpressionTree(new Number(0));
        }


        if (current.getType() == AtomicExpression.Type.OpUnaryMinus) {
            return new ExpressionTree(new UnaryMinus(), differentiate(t.getLeft(), var), null);
        }

        ExpressionTree left = differentiate(t.getLeft(), var);
        ExpressionTree right = differentiate(t.getRight(), var);

        if (current.getType() == AtomicExpression.Type.OpTimes) {
            ExpressionTree left1 = new ExpressionTree(new Times(), left, (ExpressionTree) t.getRight());
            ExpressionTree right1 = new ExpressionTree(new Times(), (ExpressionTree) t.getLeft(), right);
            return new ExpressionTree(new Plus(), left1, right1);

        }

            if (current.getType() == AtomicExpression.Type.OpPlus) {
                return new ExpressionTree(new Plus(), left, right);
            }

            if (current.getType() == AtomicExpression.Type.OpMinus) {
                return new ExpressionTree(new Minus(), left, right);
            }


        return null;
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
    }
}