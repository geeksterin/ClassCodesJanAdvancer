package graphs;

import util.Pair;

import java.util.*;

public class Graph {
    HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

    public boolean containsVertex(String vname) {
        return vces.containsKey(vname);
    }

    public void addVertex(String vname) {
        if (!containsVertex(vname)) {
            vces.put(vname, new HashMap<>());
        }
    }

    public void addEdge(String v1name, String v2name, int wt) {
        if (containsVertex(v1name) && containsVertex(v2name)) {
            vces.get(v1name).put(v2name, wt);
            vces.get(v2name).put(v1name, wt);
        }
    }

    public boolean containsEdge(String v1name, String v2name) {
        if (containsVertex(v1name) == false || containsVertex(v2name) == false) {
            return false;
        }

        return vces.get(v1name).containsKey(v2name);
    }

    public int countVertices() {
        return vces.size();
    }

    public int countEdges() {
        ArrayList<String> vnames = new ArrayList<>(vces.keySet());
        int count = 0;
        for (String vname : vnames) {
            count += vces.get(vname).size();
        }

        return count / 2;
    }

    public void removeEdge(String v1name, String v2name) {
        if (containsEdge(v1name, v2name)) {
            vces.get(v1name).remove(v2name);
            vces.get(v2name).remove(v1name);
        }
    }

    public void removeVertex(String vname) {
        if (containsVertex(vname)) {
            ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
            for (String nbr : nbrs) {
                removeEdge(nbr, vname);
            }
            vces.remove(vname);
        }
    }

    public void display() {
        System.out.println("----------------------------------------");
        ArrayList<String> vnames = new ArrayList<>(vces.keySet());

        for (String vname : vnames) {
            System.out.println(vname + "-" + vces.get(vname));
        }
    }

    public boolean hasPath(String source, String destination) {
        HashSet<String> visited = new HashSet<>();
        return hasPath(source, destination, visited);
    }

    private boolean hasPath(String vname, String destination, HashSet<String> visited) {

        if (vname.equals(destination)) {
            return true;
        }

        visited.add(vname);
        ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());

        for (String nbr : nbrs) {
            if (visited.contains(nbr)) {
                continue;
            }
            boolean bl = hasPath(nbr, destination, visited);
            if (bl == true) {
                return true;
            }
        }

        return false;
    }

    public void printHasPath(String source, String destination) {
        HashSet<String> visited = new HashSet<>();
        printHasPath(source, destination, visited, source);
    }

    private void printHasPath(String vname, String destination, HashSet<String> visited, String asf) {

        if (vname.equals(destination)) {
            System.out.println(asf);
            return;
        }

        visited.add(vname);
        ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());

        for (String nbr : nbrs) {
            if (visited.contains(nbr)) {
                continue;
            }
            printHasPath(nbr, destination, visited, asf + nbr);
        }
        visited.remove(vname);
    }

    private static String smallestPath;
    private static int smallestWt;

    public void printSmallestPW(String source, String destination) {
        HashSet<String> visited = new HashSet<>();
        smallestPath = "";
        smallestWt = Integer.MAX_VALUE;
        printSmallestPW(source, destination, visited, source, 0);
        System.out.println(smallestPath + "->" + smallestWt);
    }

    private void printSmallestPW(String vname, String destination, HashSet<String> visited, String asf, int wt) {

        if (vname.equals(destination)) {
            if (smallestWt > wt) {
                smallestWt = wt;
                smallestPath = asf;
            }
            return;
        }

        visited.add(vname);
        ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());

        for (String nbr : nbrs) {
            if (visited.contains(nbr)) {
                continue;
            }
            printSmallestPW(nbr, destination, visited, asf + nbr, wt + vces.get(vname).get(nbr));
        }
        visited.remove(vname);
    }

    private class Tpair {
        String v;
        String p;
        int w;

        public Tpair(String v, String p, int w) {
            this.v = v;
            this.p = p;
            this.w = w;
        }
    }

    public boolean bfs(String s, String d) {
        Tpair pair = new Tpair(s, s, 0);

        HashSet<String> visited = new HashSet<>();
        LinkedList<Tpair> q = new LinkedList<>();
        q.addLast(pair);
        while (q.size() > 0) {
            Tpair rem = q.removeFirst();
            visited.add(rem.v);
            System.out.println(rem.v + "@" + rem.p);
            if (rem.v.equals(d)) {
                return true;
            }
            for (String n : vces.get(rem.v).keySet()) {
                if (visited.contains(n) == false) {
                    Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
                    q.addLast(npair);
                }
            }
        }

        return false;
    }

    public boolean dfs(String s, String d) {
        Tpair pair = new Tpair(s, s, 0);

        HashSet<String> visited = new HashSet<>();
        LinkedList<Tpair> stack = new LinkedList<>();
        stack.addFirst(pair);
        while (stack.size() > 0) {
            Tpair rem = stack.removeFirst();
            visited.add(rem.v);
            System.out.println(rem.v + "@" + rem.p);
            if (rem.v.equals(d)) {
                return true;
            }
            for (String n : vces.get(rem.v).keySet()) {
                if (visited.contains(n) == false) {
                    Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
                    stack.addFirst(npair);
                }
            }
        }

        return false;
    }

    public void gcc() {

        HashSet<String> visited = new HashSet<>();
        for (String vertex : vces.keySet()) {
            if(visited.contains(vertex)){
                continue;
            }
            Tpair pair = new Tpair(vertex, vertex, 0);

            String s = "";
            LinkedList<Tpair> q = new LinkedList<>();
            q.addLast(pair);
            while (q.size() > 0) {
                Tpair rem = q.removeFirst();
                if (visited.contains(rem.v)) {
                    continue;
                }
                visited.add(rem.v);
                s += rem.v;
                for (String n : vces.get(rem.v).keySet()) {
                    if (visited.contains(n) == false) {
                        Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
                        q.addLast(npair);
                    }
                }
            }
            System.out.println(s);
        }
    }

    public boolean isCyclic(){
        HashSet<String> visited = new HashSet<>();
        for (String vertex : vces.keySet()) {
            if(visited.contains(vertex)){
                continue;
            }
            Tpair pair = new Tpair(vertex, vertex, 0);

            LinkedList<Tpair> q = new LinkedList<>();
            q.addLast(pair);
            while (q.size() > 0) {
                Tpair rem = q.removeFirst();
                if (visited.contains(rem.v)) {
                    return true;
                }
                visited.add(rem.v);
                for (String n : vces.get(rem.v).keySet()) {
                    if (visited.contains(n) == false) {
                        Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
                        q.addLast(npair);
                    }
                }
            }
        }
        return false;
    }

    public Pair<String, Pair<String, Integer>> findMinimumEdge(String curr, Set<String> visited, String source, Integer cost) {

        if(visited.contains(curr)) {
            return new Pair<>(source, new Pair<>(curr, cost));
        }

        visited.add(curr);
        HashMap<String, Integer> childs = this.vces.get(curr);
        Pair<String, Pair<String, Integer>> result = new Pair<>("null", new Pair<>("null", Integer.MAX_VALUE));
        for(Map.Entry<String, Integer> singleChild : childs.entrySet()) {
            Pair<String, Pair<String, Integer>> currentMinimum =  findMinimumEdge(singleChild.getKey(), visited, curr, singleChild.getValue());
            if(currentMinimum.getSecond().getSecond() < result.getSecond().getSecond()) {
                result.setFirst(currentMinimum.getFirst());
                result.getSecond().setFirst(currentMinimum.getSecond().getFirst());
                result.getSecond().setSecond(currentMinimum.getSecond().getSecond());
            }
        }
        return result;
    }

    public int calculateCost(String curr, HashSet<String> visited, Integer cost) {

        if(visited.contains(curr))
            return 0;

        visited.add(curr);
        int sum = cost;

        HashMap<String, Integer> childs = vces.get(curr);

        for(Map.Entry<String, Integer> singleChild : childs.entrySet()) {
            sum+=calculateCost(singleChild.getKey(), visited, singleChild.getValue());
        }
        return sum;
    }

}

//A, 1
//B, 2

//A - 0
//B - 1

//A, 1 - 0

//B, 2 - 1

//      A
//    28  10
//  B       C