import java.util.*;

public class PQ {
   public static void main(String[] args){
    //    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // //    O(logn)
    //    pq.add(10);
    //    pq.add(20);
    //    pq.add(30);
    // //    peek is O(1)
    //    System.out.println(pq.peek());
    //    System.out.println(pq.poll());
    //    System.out.println(pq.peek());
    // //    remove is also O(logn)
    //    System.out.println(pq.remove());
    //    System.out.println(pq);
    // int[] arr = {1,23,12,9,30,2,50};
    // printKlargestBetter(arr,2);

    int[] arr ={30,10,40,20,50,70,80,60,110,90,100,120};
    almostSorted(arr,2);
   } 

//    Tc- nlogn, Sc - O(n)
   public static void printKlargest(int[] arr, int k){
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int val:arr){
           pq.add(val);
       }

       for(int i = 0;i<k;i++){
           System.out.println(pq.remove()+" ");
       }
   }

//    public static void printKlargest2(int[] arr, int k){
//     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//     ArrayList<Integer> list = Arrays.asList(arr);
//     pq.addAll(list);    


//     for(int i = 0;i<k;i++){
//         System.out.println(pq.remove()+" ");
//     }
// }

public static void printKlargestBetter(int[] arr, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0;i<k;i++){
        pq.add(arr[i]);
    }

    for(int i=k;i<arr.length;i++){
        int x = pq.peek();
        if(arr[i]>x){
            pq.remove();
            pq.add(arr[i]);
        }
    }
    System.out.println(pq);
}

    public static void almostSorted(int[]arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            if(i<k+1){
                pq.add(arr[i]);
            }else{
                arr[i-k-1] = pq.remove();
                pq.add(arr[i]);
            }
        }

        for(int i=arr.length-k-1;i<arr.length;i++){
            arr[i] = pq.remove();
        }

        for(int val:arr){
            System.out.println(val);
        }
    }
}
