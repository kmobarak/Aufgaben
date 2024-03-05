/* Zusammenarbeit von: Hussein Al awassi - Khaled Mobarak - Ahmed Shaalan */

import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;                    //to use DotViewer, SingleStepper



//------------------------------------------------------------------//
public class ExampleExpression  {
    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: create an appropriate example which uses ExpressionParser
        //       and ExpressionTree
        ExpressionParser parser = new ExpressionParser();
        String example = "1 + 2 * 3";
        ExpressionTree tree = parser.parse(example);
        tree.inorder();
        tree.postorder();
        tree.preorder();
        tree.levelorder();
        double result = tree.getValue();
        System.out.println(result);
        DotViewer.displayWindow(tree.toDot(),"tree");
        System.out.println(tree.toTikZ());
    }

    }

