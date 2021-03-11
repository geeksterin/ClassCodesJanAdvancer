import java.util.*;

public class Heap {
    ArrayList<Integer> data = new ArrayList<>();

    Heap(){

    }

    public void add(int val){
        this.data.add(val);
        upheapify(this.data.size()-1);
    }

    private void upheapify(int ci){
        if(ci==0){
            return;
        }
        int pi = (ci-1)/2;
        if(this.data.get(ci)>this.data.get(pi)){
            swap(pi,ci);
            upheapify(pi);
        }
    }

    private void swap(int i,int j){
        int ith = this.data.get(i);
        int jth = this.data.get(j);

        this.data.set(i,jth);
        this.data.set(j,ith);
    }

    public void display(){
        System.out.println(this.data);
    }

}
