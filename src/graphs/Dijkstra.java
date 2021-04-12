import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args){
        Integer[][] graph = new Integer[6][6];
      graph[0][1] = 2;
      graph[0][2] = 3;
      graph[1][3] = 5;
      graph[3][5] = 2;
      graph[2][3] = 1;
      graph[2][4] = 3;
      graph[4][5] = 7;
      Dijkstra(graph, 0);
    }

    private static class Tpair implements Comparable<Tpair>{
        int v;
        String p;
        int w;

        public Tpair(int v, String p, int w){
            this.v = v;
            this.p = p;
            this.w = w;
        }

        @Override
        public int compareTo(Tpair o){
            return this.w - o.w;
        }
    }
    public static void Dijkstra(Integer[][] graph,int source){
        HashSet<Integer> visited = new HashSet<>();
        Tpair p = new Tpair(source,source+" ",0);
        PriorityQueue<Tpair> pq = new PriorityQueue<>();

        pq.add(p);
        while(pq.size()>0){
            Tpair rem = pq.remove();
            if(visited.contains(rem.v)){
                continue;
            }

            System.out.println(rem.p+"@"+rem.w);
            visited.add(rem.v);

            for(int j=0;j<graph[0].length;j++){
                if(graph[rem.v][j]!=null){
                    if(visited.contains(j)==false){
                        pq.add(new Tpair(j,rem.p+"->"+j,rem.w+graph[rem.v][j]));
                    }
                }
            }
        }
    }
}
