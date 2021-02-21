package tree;

import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

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

		Node root = new Node(50);
		Tree.add(new Node(25), 50, root, 'L');
		Tree.add(new Node(75), 50, root, 'R');
		Tree.add(new Node(12), 25, root, 'L');
		Tree.add(new Node(37), 25, root, 'R');
		Tree.add(new Node(30), 37, root, 'L');
		Tree.add(new Node(40), 37, root, 'R');
		Tree.add(new Node(62), 75, root, 'L');
		Tree.add(new Node(87), 75, root, 'R');
		Tree.add(new Node(60), 62, root, 'L');
		Tree.add(new Node(70), 62, root, 'R');

		Tree.add(new Node(90), 87, root, 'R');
//		Tree.display(root);
////        System.out.println(Tree.max(root));
////        System.out.println(Tree.min(root));
////        System.out.println(Tree.size(root));
//		System.out.println("`````````````````````````");
//		Tree.removeLeafs(null, root);
//		Tree.display(root);
//		Tree.printSingleChild(root, root.left);
//		Tree.printSingleChild(root, root.right);
//		Tree.printPath(root, 100, 200, 0, "");
//		System.out.println(root);
//		System.out.println(Tree.NodetoRoot(root, 40));
		Tree.printKaway(root, 87, 3);
	}
}

// 1
// 2 3
//    9
//  10
//