import aud.Queue;
import aud.example.expr.*;  //to extend ExpressionParser2
import aud.util.*;
//-----------------------------------------------------------------//
//ExpressionParser which is able the process `power to`./
public class ExprWithPow extends ExpressionParser2{

    // TODO: maybe overwrite some methods


    @Override  // product wurde aus der expr > ExpressionParser2 kopiert
    protected ExpressionTree product(int level) {

        // temporary storage
        Queue<ExpressionTree> expr = new Queue<ExpressionTree>();
        Queue<Integer>        op   = new Queue<Integer>();

        ExpressionTree tree=pow(level+1);

        while (lookahead() == Tokenizer.POWER){
            op.enqueue(lookahead());
            nextToken();
            expr.enqueue(pow(level+1));
        }

        // parse iteratively
        while (lookahead()==Tokenizer.TIMES || lookahead()==Tokenizer.DIVIDE) {
            op.enqueue(lookahead());
            nextToken();
            expr.enqueue(pow(level+1));
        }


        // setup tree
        while (!op.is_empty()) {
            if (op.dequeue()==Tokenizer.TIMES)
                tree=new ExpressionTree(new Times(),tree,expr.dequeue());
            else
                tree=new ExpressionTree(new Divide(),tree,expr.dequeue());
        }
        return tree;
    }



    //----------------------------------------------------------------//
    public ExpressionTree pow(int level) {
        // TODO: - implement this method which handles `power to` input
        //       - feel free to find a better solution without using this
        //         method
        ExpressionTree linkeTeil = factor(level+1);

        if (lookahead() == Tokenizer.POWER) {
            nextToken();
            ExpressionTree rechteTeil = pow(level + 1);
            return new ExpressionTree(new Power(), linkeTeil, rechteTeil);
        }
        return linkeTeil;
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples

        String a="2^3*(2+3*2/2)";
        ExprWithPow expression = new ExprWithPow();
        ExpressionTree tree = expression.parse(a);

        System.out.println(tree.getValue());
        DotViewer.displayWindow(tree.toDot(),"Baum");   // mithilfe von Klasse Dotviewer wird der Baum so gezeigt

    }
}