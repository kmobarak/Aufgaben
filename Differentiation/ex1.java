package aud.Übung6;
import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
 `ExpressionTree` with respect to a user specified variable.*/
public class ex1 {
    //----------------------------------------------------------------//
    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
        // TODO: - implement a method which computes the derivative of the
        //         given tree `t` with respect to `var`

        if (t.getData().getType() == AtomicExpression.Type.OpUnaryMinus) {
            return new ExpressionTree(new UnaryMinus(), differentiate(t.getLeft(), var), null);

        }
        if (t.getData().getType() == AtomicExpression.Type.OpPlus) {
            return new ExpressionTree(new Plus(), differentiate(t.getLeft(), var), differentiate(t.getRight(), var));

        }

        if (t.getData().getType() == AtomicExpression.Type.OpMinus) {
            return new ExpressionTree(new Minus(), differentiate(t.getLeft(), var), differentiate(t.getRight(), var));

        }
        if (t.getData().getType() == AtomicExpression.Type.OpTimes) {
            ExpressionTree linkeSeite = new ExpressionTree(new Times(), differentiate(t.getLeft(), var),   ////
                    (ExpressionTree) t.getRight());
            ExpressionTree rechteSeite = new ExpressionTree(new Times(), (ExpressionTree)t.getLeft(),
                    differentiate(t.getRight(),var));
            return new ExpressionTree(new Plus(), linkeSeite, rechteSeite);

        }
        if (t.getData().getType() == AtomicExpression.Type.TSymbol){
            if (t.getData().toString().equals(var)) {
                return new ExpressionTree(new Number(1));
            }
        }
        return new ExpressionTree(new Number(0));
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        String a = "x+x*y";
        ExpressionParser2 Exer = new ExpressionParser2();
        ExpressionTree baum1 = Exer.parse(a);


        System.out.println(baum1);
        DotViewer.displayWindow(differentiate(baum1,"a"),"1");



    }
}