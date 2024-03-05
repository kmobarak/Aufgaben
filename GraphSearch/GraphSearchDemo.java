

import aud.example.graph.*;
import aud.util.*;
//------------------------------------------------------------------//
public class GraphSearchDemo {
    private static MyGraph createGraph() {
        MyGraph graph = new MyGraph(false);

        MyNode node1 = graph.addNode();
        MyNode node2 = graph.addNode();
        MyNode node3 = graph.addNode();
        MyNode node4 = graph.addNode();
        MyNode node5 = graph.addNode();
        MyNode node6 = graph.addNode();
        MyNode node7 = graph.addNode();
        MyNode node8 = graph.addNode();


        graph.addEdge(node8, node1);
        graph.addEdge(node8, node2);
        graph.addEdge(node8, node3);
        graph.addEdge(node8, node5);
        graph.addEdge(node1, node6);
        graph.addEdge(node1, node7);
        graph.addEdge(node7, node5);
        graph.addEdge(node6, node4);
        graph.addEdge(node6, node5);

        return graph;
    }

    public static void main(String[] args) {
        MyGraph graph = createGraph();

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        MyNode startNode = graph.getSomeNode();
        bfs.start(startNode);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.start(startNode);

        String dotCode = graph.toDot();
        Graphviz graphviz = new Graphviz();
        //DotViewer dotViewer = graphviz.display(dotCode);
        //dotViewer.setExitOnClose();



    }
}
