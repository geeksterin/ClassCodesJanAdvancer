package genericTree;

public class client {
    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        GenericTree gt= new GenericTree(arr);
        int[] arr2 = {100,200,500,-1,6,-1,-1,300,700,-1,800,10,-1,12,-1,-1,9,-1,-1,4,10,22,-1,-1,-1,-1};
        GenericTree gt2= new GenericTree(arr2);
        // gt.display();
        // System.out.println(gt.size());
        // System.out.println(gt.max());
        // System.out.println(gt.height());
        // System.out.println(gt.find(50));
        // System.out.println(gt.find(55));
        // System.out.println(gt.nodetoRootPath(110));
        // gt.display();
        // gt.removeLeaves();
        // gt.linearise2();
        // gt.display();
        System.out.println(GenericTree.areSimilarShaped(gt, gt2));
    }
}
