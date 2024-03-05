import aud.example.expr.*;  //to extend ExpressionParser2
import aud.util.*;

//-----------------------------------------------------------------//
//ExpressionParser which is able the process `power to`./
public class ExprWithPow extends ExpressionParser2{

    // TODO: maybe overwrite some methods

    @Override
    protected ExpressionTree product(int level) {
        verbose(level, "<product>");

        ExpressionTree left = pow(level + 1); // only change to handle the power, all else is copied as is

        if (lookahead() == Tokenizer.TIMES) {
            nextToken();
            ExpressionTree right = product(level + 1);
            return new ExpressionTree(new Times(), left, right);
        }

        else if (lookahead() == Tokenizer.DIVIDE) {
            nextToken();
            ExpressionTree right = product(level + 1);
            return new ExpressionTree(new Divide(), left, right);
        }

        return left;
    }







    //----------------------------------------------------------------//
    public ExpressionTree pow(int level) {
        ExpressionTree base = factor(level);

        if (lookahead() == Tokenizer.POWER) {
            nextToken();
            ExpressionTree exponent = pow(level);
            return new ExpressionTree(new Power(), base, exponent);
        }
        return base;
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
    }
}