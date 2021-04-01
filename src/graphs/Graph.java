import java.util.*;

public class Graph{
    HashMap<String,HashMap<String,Integer>> vces = new HashMap<>();


    public boolean containsVertex(String vname){
        return vces.containsKey(vname);
    }

    public void addVertex(String vname){
        if(containsVertex(vname)==false){
            vces.put(vname, new HashMap<>());
        }
    }

    public void addEdge(String v1name,String v2name,int wt){
        if(containsVertex(v1name)&&containsVertex(v2name)){
            vces.get(v1name).put(v2name,wt);
            vces.get(v2name).put(v1name,wt);
        }
    }

    public boolean containsEdge(String v1name,String v2name){
        if(containsVertex(v1name)==false||containsVertex(v2name)==false){
            return false;
        }

        return vces.get(v1name).containsKey(v2name);
    }
}