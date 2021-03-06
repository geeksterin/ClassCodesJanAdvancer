package binarysearchtree;

public class Client {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int arr[] = {10, 5, 4, 20, 21, 18, 19};
        binarySearchTree.addViaArray(arr);
        //binarySearchTree.inOrder();
        System.out.println(binarySearchTree.diameterLength());
    }
}

//          10
//       5      20
//     4      18    21
//              19
//