import java.util.*;

public class linkedlist_ {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node createList(int arr[]) {
        Node head = null, tail = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = tail = new Node(arr[i]);
            } else {
                tail.next = new Node(arr[i]);
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

    // ✅ Rearrange linked list so that all odd-position nodes come first
    // followed by even-position nodes
    public static Node odd_even(Node head) {
        if (head == null || head.next == null)
            return head;

        Node odd = head; // start from 1st node
        Node even = head.next; // start from 2nd node
        Node evenHead = even; // store head of even list

        // loop until either list ends
        while (even != null && even.next != null) {
            odd.next = even.next; // link next odd
            odd = odd.next; // move odd pointer

            even.next = odd.next; // link next even
            even = even.next; // move even pointer
        }

        // attach even list at end of odd list
        odd.next = evenHead;

        return head;
    }

    public static Node sort_0_1_2(Node head) { // O(2n)
        // code here
        int cone = 0;
        int czero = 0;
        int ctwo = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0)
                czero++;
            if (temp.data == 1)
                cone++;
            if (temp.data == 2)
                ctwo++;
            if (temp.next != null) {
                temp = temp.next;
            } else {
                break;
            }

        }
        temp = head;
        for (int i = 0; i < czero; i++) {
            temp.data = 0;
            temp = temp.next;
        }
        for (int i = 0; i < cone; i++) {
            temp.data = 1;
            temp = temp.next;
        }
        for (int i = 0; i < ctwo; i++) {
            temp.data = 2;
            temp = temp.next;
        }
        return head;

    }

    public static Node sort_0_1_2_optimal(Node head) { // O(n))
        Node temp = head;
        Node zero = null;
        Node one = null;
        Node two = null;
        Node hzero = null;
        Node hone = null;
        Node htwo = null;
        while (temp != null) {
            if (temp.data == 0) {
                if (zero == null) {
                    zero = temp;
                    hzero = zero;
                    temp = temp.next;
                } else {
                    zero.next = temp;
                    zero = zero.next;
                    temp = temp.next;

                }
            } else if (temp.data == 1) {
                if (one == null) {
                    one = temp;
                    hone = one;
                    temp = temp.next;
                } else {
                    one.next = temp;
                    one = one.next;
                    temp = temp.next;

                }
            } else {
                if (two == null) {
                    two = temp;
                    htwo = two;
                    temp = temp.next;
                } else {
                    two.next = temp;
                    two = two.next;
                    temp = temp.next;
                }
            }
        }
        head = hzero;
        zero.next = hone;
        one.next = htwo;
        two.next = null;
        return head;

    }

    public static Node removeNthFromEnd(Node head, int n) {
        int count = -1;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int l = count - n;
        if (l < -1)
            return head;
        else if (l == -1) {
            head = head.next;
        } else {
            int k = 0;
            temp = head;
            while (k != l) {
                k++;
                temp = temp.next;
            }
            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    class Reverse { // O(n) SC- O(n)
        static int k = 0;
        static Node b = null;

        public static Node reverseList(Node head) {

            // base case
            if (head == null || head.next == null) {
                b = head;

                return head;
            }
            k++;
            Node temp = reverseList(head.next); // recursive call

            k--;
            temp.next = head;

            if (k == 0) {
                head.next = null;
                return b;
            }
            return head;
        }

    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node pre = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
        return head;
    }

    public static boolean isPalindrome(Node head) { //O(n)
     
 
                    
          Node fast=head;
          Node slow=head;
          while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
          }
          Node rev=reverse(slow);
          Node temp=rev;
          Node start=head;
          while(temp!=null){
                     if(start.data!=temp.data) return false;
                     start=start.next;
                     temp=temp.next;
          }
          return true;
          
        
    

    }

    public static void main(String args[]) {
        // int arr[] = { 1, 2, 3, 4, 5 };
        // print(odd_even(createList(arr)));

        // int arr2[] = { 1, 1, 2, 0, 2, 1, 2, 0 };
        // print(sort_0_1_2(createList(arr2)));
        // print(sort_0_1_2_optimal(createList(arr2)));

        // int arr3[]={1,2,3,4,5,6};
        // print(removeNthFromEnd(createList(arr3), 6));

        // int arr4[] = { 1, 2, 3, 4, 5, 6,7 };
        // print(linkedlist_.Reverse.reverseList(createList(arr4)));

        // int arr5[] = {8,0,7,0,8};
        // System.out.println(isPalindrome(createList(arr5)));

    }
}
