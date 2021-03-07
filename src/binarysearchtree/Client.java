

public class Client {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int arr[] = {10, 5, 4, 20, 21, 18, 19};
        binarySearchTree.addViaArray(arr);
        //binarySearchTree.inOrder();
        // System.out.println(binarySearchTree.diameterLength());
        // System.out.println(binarySearchTree.max());
        // System.out.println(binarySearchTree.min());
        // binarySearchTree.pir(binarySearchTree.min(),binarySearchTree.max());
        // binarySearchTree.replaceWithSumOfLargerNodes();
        binarySearchTree.remove(18);
        binarySearchTree.inOrder();

    }
}

//          10
//       5      20
//     4      18    21
//              19
//