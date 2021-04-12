import java.util.*;

public class Client {
   public static void main(String[] args) {
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

      // Graph graph = GraphUtil.prismMst(g);
      // System.out.println(graph.calculateCost("A", new HashSet<>(), 0));
      // g.display();
      // g.removeEdge("D", "E");
      // g.display();
      // g.removeVertex("D");
      // g.display();
      // System.out.println(g.countEdges());
      // System.out.println(g.countVertices());
      // System.out.println(g.hasPath("A", "G"));
      // g.printHasPath("A","G");
      // g.printSmallestPW("A","G");
      // g.bfs("A", "G");
      // System.out.println("`````````````````````````````");
      // g.dfs("A", "G");
      // g.gcc();
      // System.out.println(g.isCyclic());

      Integer[][] graph = new Integer[6][6];
      graph[0][1] = 2;
      graph[0][2] = 3;
      graph[1][3] = 5;
      graph[3][5] = 2;
      graph[2][3] = 1;
      graph[2][4] = 3;
      graph[4][5] = 7;
      Integer[][] mst = kruskal(graph);
      for(int u=0;u<mst.length;u++){
         for(int v = 0;v<mst.length;v++){
            System.out.print(mst[u][v]+"\t");
         }
         System.out.println();
      }
   }

   private static class Edge implements Comparable<Edge> {
      int u;
      int v;
      int wt;

      public Edge(int u, int v, int wt) {
         this.u = u;
         this.v = v;
         this.wt = wt;
      }

      @Override
      public int compareTo(Edge o) {
         return this.wt - o.wt;
      }
   }

   public static class DSNode {
      int vtx;
      DSNode parent;
      int rank;

      public DSNode(int vtx) {
         this.vtx = vtx;
         this.rank = 0;
         this.parent = this;
      }
   }

   public static Integer[][] kruskal(Integer[][] graph) {
      HashMap<Integer, DSNode> djset = new HashMap<>();
      Integer[][] mst = new Integer[graph.length][graph.length];
      PriorityQueue<Edge> pq = new PriorityQueue<>();

      for (int u = 0; u < graph.length; u++) {
         djset.put(u, new DSNode(u));
         for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != null) {
               pq.add(new Edge(u, v, graph[u][v]));
            }
         }
      }

      while (pq.size() > 0) {
         Edge rem = pq.remove();
         DSNode ulead = find(djset.get(rem.u));
         DSNode vlead = find(djset.get(rem.v));
         if (ulead != vlead) {
            mst[rem.u][rem.v] = rem.wt;
            merge(ulead, vlead);
         }
      }
      return mst;
   }

   private static void merge(DSNode uleadNode, DSNode vleadNode) {
      if (uleadNode.rank < vleadNode.rank) {
         uleadNode.parent = vleadNode;
      } else if (uleadNode.rank > vleadNode.rank) {
         vleadNode.parent = uleadNode;
      } else {
         uleadNode.parent = vleadNode;
         vleadNode.rank++;
      }

   }

   private static DSNode find(DSNode vnode) {
      if (vnode.parent == vnode) {
         return vnode;
      } else {
         DSNode pnode = find(vnode.parent);
         vnode.parent = pnode;
         return pnode;
      }
   }
}
