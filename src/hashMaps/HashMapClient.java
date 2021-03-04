import java.util.*;

public class HashMapClient{

     public static void main(String []args){
      // HashMap<String,Integer> hmap = new HashMap<>();

      // // put we use to store elements in HashMap
      // // o(1)
      // hmap.put("Cat",2);
      // hmap.put("mouse",3);
      // hmap.put("dog",1);
      // hmap.put("fish",1);

      // System.out.println(hmap.get("Cat"));
      
      // hmap.put("Cat",5);
      // // get method is also O(1)
      // System.out.println(hmap.get("Cat"));
      
      // hmap.remove("Cat");
      
      // // containsKey is O(1)
      
      // System.out.println(hmap);
      
      // System.out.println(hmap.size());
      
      // System.out.println(hmap.containsKey("Tiger"));
      
      // ArrayList<String> keyset = new ArrayList<>(hmap.keySet());
      
      // System.out.println(keyset);
      
      // // we can't rely on hashmap for order

      int[] one = {5,1,3,1,2,2,1};
      int[] two = {2,2,4,1,1,5,2};
      getCommonElements1(one,two);
     }

     public static void getCommonElements1(int[] one,int[] two){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:one){
           if(map.containsKey(val)){
              map.put(val,map.get(val)+1);
           }else{
              map.put(val,1);
           }
        }

        System.out.println(map);

        for(int val:two){
           if(map.containsKey(val)){
              System.out.print(val+" ");
              map.remove(val);
           }
        }
        System.out.println();
     }
}