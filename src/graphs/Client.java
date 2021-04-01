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

       g.addEdge("A", "B", 10);
       g.addEdge("A", "D", 40);
       g.addEdge("C", "B", 10);
       g.addEdge("C", "D", 10);
       g.addEdge("D", "E", 2);
       g.addEdge("E", "F", 3);
       g.addEdge("F", "G", 3);
       g.addEdge("E", "G", 8);
       g.display();
    //    g.removeEdge("D", "E");
    //    g.display();
    //    g.removeVertex("D");
    //    g.display();
       System.out.println(g.countEdges());
       System.out.println(g.countVertices());

   } 
}
