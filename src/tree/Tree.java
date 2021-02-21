package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	public static void preOrder(Node root) {

		if (root == null)
			return;

		// start is from middle
		System.out.print(root.data + " ");
		// left is second
		preOrder(root.left);
		// right is third
		preOrder(root.right);

	}

	public static void inOrder(Node root) {

		if (root == null) {
			return;
		}
		// start from left
		inOrder(root.left);
		// middle is second
		System.out.print(root.data + " ");
		// right is third
		inOrder(root.right);
	}

	public static void postOrder(Node root) {

		if (root == null) {
			return;
		}

		// start from left
		postOrder(root.left);

		// right is second
		postOrder(root.right);

		// middle is last
		System.out.print(root.data + " ");
	}

	public static int findHeight(Node root) {

		if (root == null)
			return 0;
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		return Math.max(left, right) + 1;
	}

	public static int findLeft(Node root, int number) {

		if (root == null || root.left == null)
			return -1;
		if (root.data == number)
			return root.left.data;

		int fromLeft = findLeft(root.left, number);
		int fromRight = findLeft(root.right, number);

		return fromLeft != -1 ? fromLeft : fromRight;
	}

	public static Node find(int number, Node root) {
		if (root == null)
			return null;
		if (root.data == number)
			return root;

		Node fromLeft = find(number, root.left);
		Node fromRight = find(number, root.right);

		return fromLeft != null ? fromLeft : fromRight;
	}

	public static void add(Node newNode, int atWhichToAdd, Node root, Character position) {

		if (root == null) {
			root = newNode;
			return;
		}
		Node current = find(atWhichToAdd, root);
		if (position == 'L' && current.left == null) {
			current.left = newNode;
			return;
		} else if (position == 'R' && current.right == null) {
			current.right = newNode;
			return;
		}
		throw new RuntimeException("already node present");

	}

	public static void levelOrderTraversal(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int currSize = 0;
			Node curr = queue.poll();
			if (curr == null) {
				System.out.println();
				if (queue.size() != 0)
					queue.add(null);
				continue;
			}
			System.out.print(curr.data + " ");
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left != null ? node.left.data + "->" : ".->";
		str += node.right != null ? node.data + "<-" + node.right.data : node.data + "<-.";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public static int max(Node node) {
		if (node == null) {
			return 0;
		}
		int lmax = max(node.left);
		int rmax = max(node.right);
		int mlr = Math.max(lmax, rmax);

		return Math.max(mlr, node.data);
	}

	public static int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int lmax = min(node.left);
		int rmax = min(node.right);
		int mlr = Math.min(lmax, rmax);

		return Math.min(mlr, node.data);
	}

	public static int size(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

//	Wrong Method
//	public static void removeLeafs(Node node) {
//		if (node == null) {
//			return;
//		}
//		if (node.left == null && node.right == null) {
//			node = null;
//			return;
//		}
//
//		removeLeafs(node.left);
//		removeLeafs(node.right);
//	}

	public static void removeLeafs(Node parent, Node child) {

		if (child == null) {
			return;
		}
		if (child.left == null && child.right == null) {
			if (parent.left == child) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		removeLeafs(child, child.left);
		removeLeafs(child, child.right);
	}

	public static void printSingleChild(Node parent, Node child) {
		if (child == null) {
			return;
		}
		if (parent.left == child && parent.right == null) {
			System.out.println(child.data);
		} else if (parent.right == child && parent.left == null) {
			System.out.println(child.data);

		}

		printSingleChild(child, child.left);
		printSingleChild(child, child.right);

	}

	public static void printPath(Node node, int lo, int hi, int sum, String str) {

		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sum += node.data;
			str += node.data;
			if (sum < hi && sum > lo) {
				System.out.println(str);
			}
			return;
		}

		printPath(node.left, lo, hi, sum + node.data, str + node.data + " ");
		printPath(node.right, lo, hi, sum + node.data, str + node.data + " ");
	}

	public static ArrayList<Node> NodetoRoot(Node node, int data) {
		if (node == null) {
			ArrayList<Node> br = new ArrayList<Node>();
			return br;
		}

		if (node.data == data) {
			ArrayList<Node> br = new ArrayList<Node>();
			br.add(node);
			return br;
		}
		ArrayList<Node> myres = NodetoRoot(node.left, data);
		if (myres.size() > 0) {
			myres.add(node);
			return myres;
		}

		ArrayList<Node> myres1 = NodetoRoot(node.right, data);
		if (myres1.size() > 0) {
			myres1.add(node);
			return myres1;
		}

		return new ArrayList<Node>();
	}

	public static void printKDown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
		}

		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}

	public static void printKaway(Node node, int data, int k) {
		ArrayList<Node> path = NodetoRoot(node, data);
		printKDown(path.get(0), k);
		for (int i = 1; i < path.size() && i < k; i++) {
			Node n = path.get(i);
			Node nm = path.get(i - 1);

			if (n.left == nm) {
				printKDown(n.right, k - i - 1);
			} else {
				printKDown(n.left, k - i - 1);
			}
		}

		if (path.size() > k) {
			System.out.println(path.get(k).data);
		}
	}
}
