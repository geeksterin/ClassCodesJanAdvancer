import java.util.*;

public class MedianPQ{
    PriorityQueue<Integer> p1 = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> p2 = new PriorityQueue<>();

    public void add(int data){
        if(p1.size()==0&&p2.size()==0){
            p1.add(data);
        }else if(p1.size()==0){
            p1.add(data);
        }else if(p2.size()==0){
            p2.add(data);
        }else{
            if(data<p1.peek()){
                p1.add(data);
            }else{
                p2.add(data);
            }
            balance(p1,p2);
        }
    }

    private void balance(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2) {
        if(p1.size()-p2.size()>1){
            p2.add(p1.remove());
        }else if(p2.size()-p1.size()>1){
            p1.add(p2.remove());
        }
    }

    public int peek(){
        return p1.size()>=p2.size()?p1.peek():p2.peek();
    }

    public int size(){
        return p1.size()+p2.size();
    }

    public int remove(){
        int x;
        if(p1.size()>=p2.size()){
            x = p1.remove();
        }else{
            x = p2.remove();
        }

        return x;
    }
}