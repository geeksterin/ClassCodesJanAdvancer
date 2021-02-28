package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		//o(1)
//        Node root = new Node(1);
//        Tree.add(new Node(2), 1, root, 'L');
//        Tree.add(new Node(3), 1, root, 'R');
//        Tree.add(new Node(9), 2, root, 'L');
//        Tree.add(new Node(10), 9, root, 'L');
//        Tree.inOrder(root);
//        Tree.levelOrderTraversal(root);
//        System.out.println();
//        Tree.preOrder(tree.root);
//        System.out.println();
//        Tree.postOrder(tree.root);
//        System.out.println(Tree.findLeft(tree.root, 2));
//        System.out.println(Tree.findHeight(tree.root));
//		Tree.add(new Node(25), 50, root, 'L');
//		Tree.add(new Node(75), 50, root, 'R');
//		Tree.add(new Node(12), 25, root, 'L');
//		Tree.add(new Node(37), 25, root, 'R');
//		Tree.add(new Node(30), 37, root, 'L');
//		Tree.add(new Node(40), 37, root, 'R');
//		Tree.add(new Node(62), 75, root, 'L');
//		Tree.add(new Node(87), 75, root, 'R');
//		Tree.add(new Node(60), 62, root, 'L');
//		Tree.add(new Node(70), 62, root, 'R');
//		Tree.add(new Node(90), 87, root, 'R');
//		// Tree.add(new Node(10), 90, root, 'R');
//
//		Tree.add(new Node(90), 87, root, 'R');
//		Tree.display(root);
////        System.out.println(Tree.max(root));
////        System.out.println(Tree.min(root));
////        System.out.println(Tree.size(root));
//		System.out.println("`````````````````````````");
//		Tree.removeLeafs(null, root);
		// Tree.display(root);
//		Tree.printSingleChild(root, root.left);
//		Tree.printSingleChild(root, root.right);
//		Tree.printPath(root, 100, 200, 0, "");
//		System.out.println(root);
//		System.out.println(Tree.NodetoRoot(root, 40));
//		Tree.add(new Node(2), 1, root, 'L');
//		Tree.add(new Node(3), 1, root, 'R');
		//Tree.rightViewWithQueue(root);
		// System.out.println(Tree.LowestCommonAncestor(root, 75, 90));
		// Tree.preIter(root);
		// Tree.postIter(root);
		// Tree.inIter(root);
		// System.out.println(Tree.isBalancedImprove(root));
		// System.out.println(Tree.diameter(root));
//		System.out.println(Tree.isBst(root));
//		System.out.println(Tree.isBstbad(root));
		Node root1 = new Node(50);
        Tree.add(new Node(25), 50, root1, 'L');
        Tree.add(new Node(75), 50, root1, 'R');
		Tree.add(new Node(30), 25, root1, 'L');
		Tree.add(new Node(20), 25, root1, 'R');
		Tree.add(new Node(70), 75, root1, 'R');
		Tree.add(new Node(65), 75, root1, 'L');

		Node root2 = new Node(25);
		Tree.add(new Node(30), 25, root2, 'L');
		Tree.add(new Node(20), 25, root2, 'R');
		System.out.println(Tree.isSubtree(root1, root2));
//		Node root2 = new Node(50);
//		Tree.add(new Node(25), 50, root2, 'L');
//		Tree.add(new Node(75), 50, root2, 'R');
//		Tree.add(new Node(30), 25, root2, 'L');
//		Tree.add(new Node(20), 25, root2, 'R');
//		Tree.add(new Node(70), 75, root2, 'R');
//		Tree.add(new Node(65), 75, root2, 'L');

        //Tree.inOrder(root);
//        Tree.convertToLinkedList(root1);
//        Tree.inOrder(root1);
        //Tree.inOrder(root);
	}
}

// Hashing =
// array of size 5                     /5
// 52, 42, 32, 22, 2
// 5, 1, 52, 33
//		  |
//		  |
//		  42

//  "ravi", 49
//   "karan", 87