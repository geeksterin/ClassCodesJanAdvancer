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

    public int countVertices(){
        return vces.size();
    }

    public int countEdges(){
        ArrayList<String> vnames = new ArrayList<>(vces.keySet());
        int count =0;
        for(String vname:vnames){
            count+= vces.get(vname).size();
        }

        return count/2;
    }

    public void removeEdge(String v1name,String v2name){
        if(containsEdge(v1name, v2name)){
            vces.get(v1name).remove(v2name);
            vces.get(v2name).remove(v1name);
        }
    }

    public void removeVertex(String vname){
        if(containsVertex(vname)){
            ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
            for(String nbr:nbrs){
                removeEdge(nbr, vname);
            }
            vces.remove(vname);
        }
    }

    public void display(){
        System.out.println("----------------------------------------");
        ArrayList<String> vnames = new ArrayList<>(vces.keySet());

        for(String vname:vnames){
            System.out.println(vname+"-"+vces.get(vname));
        }
    }

    public boolean hasPath(String source,String destination){
        HashSet<String> visited = new HashSet<>();
        return hasPath(source, destination,visited);
    }


    private boolean hasPath(String vname,String destination,HashSet<String> visited){

        if(vname.equals(destination)){
            return true;
        }

        visited.add(vname);
        ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());

        for(String nbr:nbrs){
            if(visited.contains(nbr)){
                continue;
            }
            boolean bl = hasPath(nbr,destination,visited);
            if(bl==true){
                return true;
            }
        }

        return false;
    }

    public void printHasPath(String source,String destination){
        HashSet<String> visited = new HashSet<>();
        printHasPath(source, destination,visited,source);
    }


    private void printHasPath(String vname,String destination,HashSet<String> visited,String asf){

        if(vname.equals(destination)){
            System.out.println(asf);
            return ;
        }

        visited.add(vname);
        ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());

        for(String nbr:nbrs){
            if(visited.contains(nbr)){
                continue;
            }
            printHasPath(nbr,destination,visited,asf+nbr);           
        }
        visited.remove(vname);
    }
}