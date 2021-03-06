package hashMaps;

import arrays.Array;
import com.sun.tools.javac.util.Pair;

import java.util.*;

public class HashMapClient{

     public static void main(String []args){
        HashMapClient client = new HashMapClient();
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
      //longestSequence(arr);
        //System.out.println(client.twoSum(Arrays.<Integer>asList(2,12,9,16,10,5,3,20,25,11,1,8,6),8));
        //System.out.println(client.groupAnagramsTogether(Arrays.asList("cat", "rabbit", "dog", "act", "god")));
        //System.out.println(client.longestUniqueSubstringLength("dhananjyan"));
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

     public Pair<Integer, Integer> twoSum(List<Integer> list,int target) {

        Set<Integer> set = new HashSet<>();
        for(Integer a : list) {  //2, 1, 3            5
           int num = target - a;
           if(set.contains(num)) {
              return new Pair<>(num, a);
           } else {
              set.add(a);
           }
         }
         return new Pair<>(-1, -1);
     }

     public ArrayList<ArrayList<String>> groupAnagramsTogether(List<String> arrayList) {

        //Hashmap of Hashmap
        Map<Map<Character, Integer>, List<String>> mainMap= new HashMap<>();

        for(String str : arrayList) {

           Map<Character, Integer> map = new HashMap<>();
           for(int i=0;i<str.length();i++) {
              if(map.containsKey(str.charAt(i))) {
                 map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
              } else {
                 map.put(str.charAt(i), 1);
              }
           }

           if(mainMap.containsKey(map)) {
              mainMap.get(map).add(str);
           } else {
              ArrayList<String> list = new ArrayList<>();
              list.add(str);
              mainMap.put(map, list);
           }

        }
        ArrayList<ArrayList<String>>  result = new ArrayList<>();
        for(List<String> list : mainMap.values()) {
           result.add((ArrayList<String>) list);
        }
        return result;
     }
     
     public int longestUniqueSubstringLength(String string) {
        
        int max_length = Integer.MIN_VALUE;
        int start = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int end = 0; end < string.length(); end++) {
           
           if(hashMap.containsKey(string.charAt(end))) {
              start = Math.max(start, hashMap.get(string.charAt(end)) + 1);
              hashMap.put(string.charAt(end), end);
           } else {
              hashMap.put(string.charAt(end), end);
           }
           max_length = Math.max(max_length, end-start+1); //6
           
        }
        return max_length;
     }
}

//abcdaefbghi
//a, 4
//b, 1
//c, 2
//d, 3
//e, 5
//f, 6