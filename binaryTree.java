import java.util.*;

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
            return newNode;  //returns root
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
 
        public static int height(Node tree){ //O(n)
    if (tree==null) {
        return 0;
    }
    int lh=height(tree.left);
    int rh=height(tree.right);
    return Math.max(lh,rh)+1;
   }
  
 
         public static int no_Of_Nodes(Node tree){
           
            if (tree==null) {
                return 0;
            }
            
            
         return   no_Of_Nodes(tree.right)+ no_Of_Nodes(tree.left)+1;
         
         }

        public static int sum_of_nodes(Node root){
            if (root==null) {
                return 0;
            }
          return root.data+sum_of_nodes(root.left)+sum_of_nodes(root.right);
        }
        
        public static int diameter_of_tree(Node root){  //O(n^2)

      if (root==null) {
         return 0;
    }
    int ld=diameter_of_tree(root.left);
    int rd=diameter_of_tree(root.right);
    int heightleft=height(root.left);
    int heightright=height(root.right);
    int self=heightleft+heightright+1;
    return Math.max(Math.max(ld,rd),self);






        }



        }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
 /* 1
   / \
  2    3
 / \    \
4   5    6  
 */

        BinaryTree tree = new BinaryTree();
        
        Node root = tree.buildTree(nodes);

        // tree.printPreOrder(root);

        // tree.printInOrder(root);

        // tree.printPostOrder(root);

       // tree.printLevelOrder(root);

      //  System.out.println(tree.height(root));

     // System.out.println(tree.no_Of_Nodes(root));

    // System.out.println(tree.sum_of_nodes(root));
    
    //  System.out.println(tree.diameter_of_tree(root));
    }
}
