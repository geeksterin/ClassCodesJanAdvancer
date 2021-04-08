package graphs;

import java.util.HashSet;

public class Client {
   public static void main(String[] args){
       Graph g = new Graph();
       g.addVertex("A");
       g.addVertex("B");
       g.addVertex("C");
       g.addVertex("D");
       g.addVertex("E");
       g.addVertex("F");
       g.addVertex("G");

       g.addEdge("A", "B", 28);
       g.addEdge("B", "A", 28);
       g.addEdge("B", "C", 16);
       g.addEdge("C", "B", 16);
       g.addEdge("C", "D", 12);
       g.addEdge("D", "C", 12);
       g.addEdge("D", "E", 22);
       g.addEdge("E", "D", 22);
       g.addEdge("E", "F", 25);
       g.addEdge("F", "E", 25);
       g.addEdge("F", "A", 10);
       g.addEdge("A", "F", 10);
       g.addEdge("B", "G", 14);
       g.addEdge("G", "B", 14);
       g.addEdge("D", "G", 18);
       g.addEdge("G", "D", 18);
       g.addEdge("G", "E", 24);
       g.addEdge("E", "G", 24);

       Graph graph = GraphUtil.prismMst(g);
       System.out.println(graph.calculateCost("A", new HashSet<>(), 0));
    //    g.display();
    //    g.removeEdge("D", "E");
    //    g.display();
    //    g.removeVertex("D");
    //    g.display();
    //    System.out.println(g.countEdges());
    //    System.out.println(g.countVertices());
    // System.out.println(g.hasPath("A", "G"));
      //   g.printHasPath("A","G");
      //   g.printSmallestPW("A","G");
      // g.bfs("A", "G");
      // System.out.println("`````````````````````````````");
      // g.dfs("A", "G");
      // g.gcc();
     // System.out.println(g.isCyclic());
   } 
}
