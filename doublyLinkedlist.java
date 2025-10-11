import java.util.ArrayList;

public class doublyLinkedlist {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node createList(int arr[]) {
        Node head = null, tail = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = tail = new Node(arr[i]);
            } else {
                tail.next = new Node(arr[i]);
                tail.next.prev = tail;
                tail = tail.next;
            }
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node deleteAllOccurOfX(Node head, int x) {

        if (head == null)
            return head;
        Node temp = head;
        while (temp != null) {
            if (head.data == x) {
                head = head.next;
                head.prev = null;
            } else if (temp.next == null && temp.data == x) {
                temp.prev.next = null;
            } else {
                if (temp.data == x) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
            Node head) {
        // code here
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        if (head == null || head.next == null) {
            return new ArrayList<ArrayList<Integer>>();

        }

        Node fast = head;
        while (fast.next != null) {

            fast = fast.next;
        }
        Node left = head;
        ;
        Node right = fast;
        ;
        while (left != right && left != right.next) {
            int sum = left.data + right.data;
            if (sum == target) {
                ArrayList<Integer> r = new ArrayList<>();
                r.add(left.data);
                r.add(right.data);
                a.add(r);
                right = right.prev;
                left = left.next;
            } else if (sum > target) {
                right = right.prev;
            } else {
                left = left.next;

            }
        }
        return a;
    }


    
    public static void main(String args[]) {

        // int arr[] = { 2, 2, 1, 3, 4, 2, 6, 2 };
        // print(deleteAllOccurOfX(createList(arr), 2));

    //     int arr2[]={1,2,3,4,5,6};
    //    ArrayList<ArrayList<Integer>> arr3=findPairsWithGivenSum(5, createList(arr2));
    }
}
