package tree;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Node root = new Node(1);
        Tree.add(new Node(2), 1, root, 'L');
        Tree.add(new Node(3), 1, root, 'R');
        Tree.add(new Node(9), 2, root, 'L');
        Tree.add(new Node(10), 9, root, 'L');
//        Tree.inOrder(root);
        Tree.levelOrderTraversal(root);
//        System.out.println();
//        Tree.preOrder(tree.root);
//        System.out.println();
//        Tree.postOrder(tree.root);
//        System.out.println(Tree.findLeft(tree.root, 2));
//        System.out.println(Tree.findHeight(tree.root));
    }
}

   //     1
   //   2   3
//    9
//  10
//