import java.util.*;

import javax.swing.tree.TreeNode;

public class binaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) { // O(n)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; // returns root
        }

        public static void printPreOrder(Node tree) { // O(n)
            if (tree == null) {

                return;
            }
            System.out.print(tree.data + " ");
            printPreOrder(tree.left); // printing left subtree
            printPreOrder(tree.right); // printning right subtree
        }

        public static void printInOrder(Node tree) { // O(n)
            if (tree == null) {

                return;
            }

            printInOrder(tree.left); // printing left subtree
            System.out.print(tree.data + " ");
            printInOrder(tree.right); // printning right subtree
        }

        public static void printPostOrder(Node tree) { // O(n)
            if (tree == null) {

                return;
            }

            printPostOrder(tree.left); // printing left subtree
            printPostOrder(tree.right); // printning right subtree
            System.out.print(tree.data + " ");

        }

        public List<Integer> Iterative_Method_preorderTraversal(Node root) {

            ArrayList<Integer> a = new ArrayList<>();
            if (root == null)
                return a;
            Stack<Node> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()) {
                Node x = s.pop();

                a.add(x.data);
                if (x.right != null)
                    s.push(x.right);
                if (x.left != null)
                    s.push(x.left);

            }
            return a;
        }

        public List<Integer> Iterative_method_inorderTraversal(Node root) {
            ArrayList<Integer> a = new ArrayList<>();
            if (root == null)
                return a;
            Stack<Node> s = new Stack<>();
            Node node = root;
            while (true) {
                if (node != null) {
                    s.push(node);
                    node = node.left;
                } else {
                    if (s.isEmpty()) {
                        break;
                    }
                    node = s.pop();
                    a.add(node.data);
                    node = node.right;
                }

            }
            return a;

        }

        public static void printLevelOrder(Node tree) { // O(n)

            if (tree == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(tree);
            q.add(null);
            while (!q.isEmpty()) {
                Node a = q.remove();
                if (a == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }

                } else {
                    System.out.print(a.data + " ");
                    if (a.left != null) {
                        q.add(a.left);
                    }
                    if (a.right != null) {
                        q.add(a.right);
                    }

                }

            }
        }

        public static int height(Node tree) { // O(n)
            if (tree == null) {
                return 0;
            }
            int lh = height(tree.left);
            int rh = height(tree.right);
            return Math.max(lh, rh) + 1;
        }

        public static int no_Of_Nodes(Node tree) {

            if (tree == null) {
                return 0;
            }

            return no_Of_Nodes(tree.right) + no_Of_Nodes(tree.left) + 1;

        }

        public static int sum_of_nodes(Node root) {
            if (root == null) {
                return 0;
            }
            return root.data + sum_of_nodes(root.left) + sum_of_nodes(root.right);
        }

        public static int diameter_of_tree(Node root) { // O(n^2) approach 1st

            if (root == null) {
                return 0;
            }
            int ld = diameter_of_tree(root.left); // left diameter
            int rd = diameter_of_tree(root.right);// rigt diameter
            int heightleft = height(root.left);
            int heightright = height(root.right);
            int self = heightleft + heightright + 1;
            return Math.max(Math.max(ld, rd), self);

        }

        public static class diameter {// Approach 2nd
            int dia;
            int ht;

            diameter(int dia, int ht) {
                this.dia = dia;
                this.ht = ht;
            }

            public static diameter diameterApproach2(Node root) { // O(n)
                if (root == null) {
                    return new diameter(0, 0);
                }
                diameter left = diameterApproach2(root.left);
                diameter right = diameterApproach2(root.right);

                int diam = Math.max(Math.max(left.dia, right.dia), left.ht + right.ht + 1);
                int ht = Math.max(left.ht, right.ht) + 1;

                return new diameter(diam, ht);
            }
        }

        static class SubTree {
            public static boolean isIdentical(Node node, Node subRoot) {
                if (node == null && subRoot == null) {
                    return true;
                } else if (node == null || subRoot == null || node.data != subRoot.data) {
                    return false;
                }
                if (!isIdentical(node.left, subRoot.left)) {
                    return false;
                }
                if (!isIdentical(node.right, subRoot.right)) {
                    return false;
                }
                return true;
            }

            public static boolean subtree_of_another_tree(Node root, Node subtree) {
                if (root == null) {
                    return false;
                }
                if (root.data == subtree.data) {

                    if (isIdentical(root, subtree)) {
                        return true;
                    }
                }

                return subtree_of_another_tree(root.left, subtree) || subtree_of_another_tree(root.right, subtree);
            }

        }

        static class TopView {
            Node node;
            int hd;// horizontal distance

            TopView(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }

            public static void topView(Node root) {
                // level order
                Queue<TopView> q = new LinkedList<>();

                HashMap<Integer, Node> map = new HashMap<>();
                int min = 0, max = 0;
                q.add(new TopView(root, 0));
                q.add(null);

                while (!q.isEmpty()) {
                    TopView curr = q.remove();
                    if (curr == null) {
                        if (q.isEmpty()) {
                            break;
                        } else {
                            q.add(null);
                        }
                    } else {
                        if (!map.containsKey(curr.hd)) { // first time my hd is occuring
                            map.put(curr.hd, curr.node);

                        }
                        if (curr.node.left != null) {
                            q.add(new TopView(curr.node.left, curr.hd - 1));
                            min = Math.min(min, curr.hd - 1);
                        }
                        if (curr.node.right != null) {
                            q.add(new TopView(curr.node.right, curr.hd + 1));
                            max = Math.max(max, curr.hd + 1);
                        }
                    }

                }
                for (int i = min; i <= max; i++) {
                    System.out.print(map.get(i).data + " ");
                }
            }

        }

        public static void kth_level(Node root, int n) { // approach 1 //O(n)
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int i = 1;
            while (!q.isEmpty()) {
                Node a = q.remove();
                if (a == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        i++;
                        if (i == n) {
                            while (!q.isEmpty()) {
                                System.out.print(q.remove().data + " ");
                            }
                            return;
                        }
                        q.add(null);
                    }
                } else {

                    if (a.left != null) {
                        q.add(a.left);
                    }
                    if (a.right != null) {
                        q.add(a.right);
                    }
                }
            }
        }

        public static void kth_level_approach_2(Node root, int n, int level) {// O(n)
            if (root == null) {
                return;
            }
            if (level == n) {
                System.out.print(root.data + " ");
                return;
            }
            kth_level_approach_2(root.left, n, level + 1);

            kth_level_approach_2(root.right, n, level + 1);

        }

        static class Ancestor {

            public static boolean getpath(int num, Node root, ArrayList<Node> path) {// O(n)
                if (root == null) {
                    return false;
                }
                path.add(root);
                if (root.data == num) {
                    return true;
                }
                boolean foundleft = getpath(num, root.left, path);
                boolean foundright = getpath(num, root.right, path);
                if (foundright || foundleft) {
                    return true;
                }
                path.remove(path.size() - 1);
                return false;
            }

            public static void lowest_common_ancestor(Node root, int num1, int num2) {// O(n) space-O(n)
                ArrayList<Node> path1 = new ArrayList<>();
                ArrayList<Node> path2 = new ArrayList<>();
                getpath(num1, root, path1);
                getpath(num2, root, path2);
                int i = 0;
                for (; i < path1.size() && i < path2.size(); i++) {
                    if (path1.get(i) != path2.get(i)) {

                        break;
                    }
                }
                System.out.println(path1.get(i - 1).data);
            }
        }

        public static Node lowest_common_ancestor_approach2(Node root, int n, int m) {
            if (root == null || root.data == n || root.data == m) {
                return root;
            }
            Node leftlca = lowest_common_ancestor_approach2(root.left, n, m);
            Node rightlcs = lowest_common_ancestor_approach2(root.right, n, m);
            if (leftlca == null) {
                return rightlcs;
            }
            if (rightlcs == null) {
                return leftlca;
            }
            return root;
        }

        public static class minimum_distance_btw_two_node {

            public static int lcadist(Node root, int n) {
                if (root == null) {
                    return -1;
                }
                if (root.data == n) {
                    return 0;
                }
                int leftDist = lcadist(root.left, n);
                int rightDist = lcadist(root.right, n);
                if (leftDist == -1 && rightDist == -1) {
                    return -1;
                } else if (leftDist == -1) {
                    return rightDist + 1;
                } else {
                    return leftDist + 1;
                }
            }

            public static int minimum_distance_btw_two_node(Node root, int a, int b) {
                Node lca = lowest_common_ancestor_approach2(root, a, b);
                int dist1 = lcadist(lca, a);
                int dist2 = lcadist(lca, b);
                return dist1 + dist2;
            }
        }

        public static int kth_ancestor(Node root, int n, int k) {
            // if (root == null) {
            // return -1;
            // }
            // if (root.data == n) {
            // return 1;
            // }
            // int dist1 = kth_ancestor(root.left, n, k);
            // int dist2 = kth_ancestor(root.right, n, k);

            // if (dist1 == k) {
            // System.out.println(root.data);
            // return -1;
            // }
            // if (dist2 == k) {
            // System.out.println(root.data);
            // return -1;
            // }
            // if (dist1 == -1 && dist2 != -1) {
            // return dist2 = dist2 + 1;
            // }
            // if (dist2 == -1 && dist1 != -1) {
            // return dist1 = dist1 + 1;
            // }

            // return -1;
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int dist1 = kth_ancestor(root.left, n, k);
            int dist2 = kth_ancestor(root.right, n, k);

            if (dist1 == -1 && dist2 == -1) {
                return -1;
            }

            int max = Math.max(dist1, dist2);
            if (max + 1 == k) {
                System.out.println(root.data);

            }
            return max + 1;

        }

        public static class SumTree {
            public static int sum(Node root) {
                if (root == null) {
                    return 0;
                }
                int lsum = sum(root.left);
                int rsum = sum(root.right);
                return lsum + rsum + root.data;

            }

            public static void transform_to_sum_tree(Node root) {
                if (root == null) {
                    return;
                }
                int lsum = sum(root.left);
                int rsum = sum(root.right);
                root.data = lsum + rsum;
                transform_to_sum_tree(root.left);
                transform_to_sum_tree(root.right);

            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        // tree.printPreOrder(root);

        // tree.printInOrder(root);

        // tree.printPostOrder(root);

        // tree.printLevelOrder(root);

        // System.out.println(tree.height(root));

        // System.out.println(tree.no_Of_Nodes(root));

        // System.out.println(tree.sum_of_nodes(root));

        // -----------------------------------------------

        // System.out.println(tree.diameter_of_tree(root));

        // System.out.println( ( BinaryTree.diameter.diameterApproach2(root)).dia);

        // --------------------Sub Tree------------------------------

        // int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };
        // BinaryTree tree2 = new BinaryTree();

        // BinaryTree.idx = -1;
        // Node subtree = tree2.buildTree(nodes2);
        // System.out.println(BinaryTree.SubTree.subtree_of_another_tree(root,
        // subtree));

        // -------------------------------------------------------
        // BinaryTree.TopView.topView(root);

        // ---------------------------------------------------

        // tree.kth_level(root, 3);
        // tree.kth_level_approach_2(root, 3, 1);

        // ------------------------------
        // BinaryTree.Ancestor.lowest_common_ancestor(root, 4, 6);

        // System.out.println( tree.lowest_common_ancestor_approach2(root, 4, 5).data);

        // -------------------------------------------------------

        // System.out.println(BinaryTree.minimum_distance_btw_two_node.minimum_distance_btw_two_node(root,
        // 4, 3));

        // -----------------------------------------------------------

        // tree.kth_ancestor(root, 4, 0);

        // ----------------transform_to_sum_tree----------------------------

        // BinaryTree.SumTree.transform_to_sum_tree(root);
        // tree.printPreOrder(root);
    }
}
