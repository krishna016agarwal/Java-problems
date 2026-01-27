import java.util.*;

public class BinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    class FindPreSuc {
        ArrayList<Node> a = new ArrayList<>();
        Node prev = null;

        public ArrayList<Node> findPreSuc(Node root, int key) {

            helper(root, key);
            if (a.size() == 0) {
                a.add(prev);
                a.add(null);
            }
            return a;
        }

        public void helper(Node root, int k) {
            if (root == null)
                return;
            helper(root.left, k);
            if (root.data > k) {
                a.add(prev);
                a.add(root);
                return;
            }
            if (root.data != k)
                prev = root;

            helper(root.right, k);
        }
    }

    class BSTIterator {
        Stack<Node> stack;

        public BSTIterator(Node root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            Node curr = stack.pop();
            if (curr.right != null) {
                pushLeft(curr.right);
            }
            return curr.data;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
