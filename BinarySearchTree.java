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

    class FindTarget {

        Stack<Node> left = new Stack<>();
        Stack<Node> right = new Stack<>();

        void addAllLeft(Node node) {
            while (node != null) {
                left.push(node);
                node = node.left;
            }
        }

        void addAllRight(Node node) {
            while (node != null) {
                right.push(node);
                node = node.right;
            }
        }

        Node next() {
            Node node = left.pop();
            if (node.right != null)
                addAllLeft(node.right);
            return node;
        }

        Node before() {
            Node node = right.pop();
            if (node.left != null)
                addAllRight(node.left);
            return node;
        }

        public boolean findTarget(Node root, int k) {
            if (root == null)
                return false;

            addAllLeft(root);
            addAllRight(root);

            Node l = next();
            Node r = before();

            while (l != r) { 
                int sum = l.data + r.data;

                if (sum == k)
                    return true;
                else if (sum < k) {
                    if (left.isEmpty())
                        break;
                    l = next();
                } else {
                    if (right.isEmpty())
                        break;
                    r = before();
                }
            }
            return false;
        }
    }

}
