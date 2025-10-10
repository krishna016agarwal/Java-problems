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

    public static boolean isPalindrome(Node head) { // O(n)

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rev = reverse(slow);
        Node temp = rev;
        Node start = head;
        while (temp != null) {
            if (start.data != temp.data)
                return false;
            start = start.next;
            temp = temp.next;
        }
        return true;

    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node temp1 = reverse(l1);
        Node temp2 = reverse(l2);
        int carry = 0;
        Node b = null; // new linked list
        Node tail = null;
        while (temp1 != null && temp2 != null) {
            int data = temp1.data + temp2.data + carry;
            int i = 0;
            if (data > 9) {
                i = data % 10;
                carry = data / 10;
            } else {
                i = data;
                carry = 0;
            }
            Node a = new Node(i);
            if (b == null) {
                b = tail = a;
            } else {
                tail.next = a;
                tail = tail.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            int data = temp1.data + carry;
            int i = 0;
            if (data > 9) {
                i = data % 10;
                carry = data / 10;
            } else {
                i = data;
                carry = 0;
            }
            Node a = new Node(i);
            if (b == null) {
                b = tail = a;
            } else {
                tail.next = a;
                tail = tail.next;
            }
            temp1 = temp1.next;

        }
        while (temp2 != null) {
            int data = temp2.data + carry;
            int i = 0;
            if (data > 9) {
                i = data % 10;
                carry = data / 10;
            } else {
                i = data;
                carry = 0;
            }
            Node a = new Node(i);
            if (b == null) {
                b = tail = a;
            } else {
                tail.next = a;
                tail = tail.next;
            }
            temp2 = temp2.next;

        }
        if (carry > 0) {
            Node a = new Node(carry);
            tail.next = a;
            tail = tail.next;
        }
        return reverse(b);
    }

    public static Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        Node temp = head;
        int carry = 1; // start with +1
        Node prev = null;

        // Step 2: Traverse and add
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            prev = temp;
            temp = temp.next;
        }

        // Step 3: If carry still remains (like 999 -> 1000)
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        // Step 4: Reverse again to restore order
        head = reverse(head);

        return head;
    }

    class AddOne {
        private static int addCarry(Node head) {
            if (head == null)
                return 1; // base case: at the end, we add 1

            int carry = addCarry(head.next);
            int sum = head.data + carry;
            head.data = sum % 10;
            return sum / 10; // carry (0 or 1)
        }

        public static Node addOne_recurvive(Node head) {
            int carry = addCarry(head);

            if (carry > 0) { // if carry remains, add new node at front
                Node newHead = new Node(carry);
                newHead.next = head;
                head = newHead;
            }
            return head;
        }
    }

    public static Node getIntersectionNode(Node headA, Node headB) { // O(n+2m)
        Node temp1 = headA;
        Node temp2 = headB;
        int l1 = 0;
        int l2 = 0;
        while (temp1.next != null) { // O(n)
            l1++;
            temp1 = temp1.next;
        }
        while (temp2.next != null) { // O(m)
            l2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        while (l1 != l2) { // O(m-n)
            if (l1 > l2) {
                l1--;
                temp1 = temp1.next;
            } else {
                l2--;
                temp2 = temp2.next;
            }
        }
        while (temp1 != null && temp2 != null) { // O(n)
            if (temp1 == temp2)
                return temp1;
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }

    public static Node getIntersectionNode_optimal(Node headA, Node headB) {
        Node temp1 = headA;
        Node temp2 = headB;
        if (headA == null || headB == null)
            return null;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) {
                return temp1;
            }
            if (temp1 == null) {
                temp1 = headB;
            }
            ;
            if (temp2 == null) {
                temp2 = headA;
            }
            ;

        }

        return temp1;

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

        // int arr6[]={9,9,9,9,9};
        // int arr7[]={9,9};
        // print(addTwoNumbers(createList(arr6),createList(arr7)));

        // int arr8[]={4,5,6,9};
        // print(linkedlist_.AddOne.addOne_recurvive(createList(arr8)));

    }
}
