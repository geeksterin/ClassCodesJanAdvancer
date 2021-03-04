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

      // int[] one = {5,1,3,1,2,2,1};
      // int[] two = {2,2,4,1,1,5,2};
      // getCommonElements2(one,two);

      int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
      longestSequence(arr);
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

     public static void getCommonElements2(int[] one,int[] two){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:one){
           if(map.containsKey(val)){
               map.put(val,map.get(val)+1);
           }else{
               map.put(val,1);
           }
        }

        for(int val:two){
           if(map.containsKey(val)){
              System.out.println(val);
              map.put(val,map.get(val)-1);

              if(map.get(val)<=0){
                 map.remove(val);
              }
           }
        }
     }


     public static void longestSequence(int[] arr){
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int val:arr){
           map.put(val,false);
        } 

        for(int val:arr){
           if(map.containsKey(val-1)==false){
              map.put(val,true);
           }
        }

        int sidx = -1;
        int maxCount = 0;
        for(int val:arr){
           int count =1;
           if(map.get(val)==true){
              while(map.containsKey(val+count)){
                 count++;
              }
            //   count--;
              if(count>maxCount){
                 maxCount = count;
                 sidx = val;
              }
           }
        }

        System.out.println(sidx+" "+maxCount);
     }
}