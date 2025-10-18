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

    public int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;
        if (head == null || head.next == null)
            return 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        int len = 1;
        if (fast != slow)
            return 0;
        slow = slow.next;
        while (fast != slow) {
            len++;

            slow = slow.next;
        }
        return len;

    }

    public static Node deleteMiddle(Node head) {
        if (head.next == null) {
            head = null;
            return head;
        }
        int k = 0;
        Node temp = head;
        while (temp.next != null) {
            k++;
            temp = temp.next;
        }
        int mid = k % 2 == 0 ? k / 2 - 1 : k / 2;
        temp = head;
        k = 0;
        while (k != mid) {
            k++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static Node detectCycle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static Node deleteDuplicates(Node head) { // O(n)
        if (head == null || head.next == null)
            return head;
        Node pre = null;
        Node curr = head;
        Node nex = curr.next;
        while (curr.next != null && curr != null) {
            if (nex != null && curr.data == nex.data) {
                while (nex != null && curr.data == nex.data) {
                    nex = nex.next;
                }
                if (pre == null || (pre == head && pre == curr)) {
                    head = nex;
                    pre = nex;
                    curr = nex;
                    if (curr == null) {
                        return head;
                    }
                    nex = curr.next;
                } else { // pre == head but pre != curr
                    pre.next = nex;
                    curr = nex;
                    if (curr == null) {
                        return head;
                    }
                    nex = nex.next;
                }
            } else {
                pre = curr;
                curr = nex;
                if (curr == null) {
                    return head;
                }
                nex = curr.next;
            }
        }

        return head;

    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        Node temp = head;
        Node knode = head;
        Node nextnode = head;
        Node pre = null;
        if (k == 1)
            return head;
        while (temp != null) {
            int n = 1;
            // Node first=temp;
            while (knode.next != null && temp != null && n != k) {
                n++;
                knode = knode.next;
            }
            if (n != k && (knode.next == null || knode == null)) {
                nextnode.next = temp;

            }
            if (knode == null)
                return head;

            pre = knode.next;
            knode.next = null;
            Node revhead = reverse(temp);
            if (temp == head) {
                head = revhead;
            }
            print(revhead);
            if (knode == head && knode.next == null) {
                return head;
            }
            nextnode.next = knode;
            nextnode = temp;
            temp = pre;
            knode = pre;

        }
        return head;
    }

    public static Node rotate(Node head) {
        Node temp = head;
        Node helper = head;

        while (temp.next != null) {
            if (temp != head) {
                int rev = temp.data;
                temp.data = helper.data;
                helper.data = rev;
            }
            temp = temp.next;

        }
        int rev = temp.data;
        temp.data = helper.data;
        helper.data = rev;

        return head;
    }

    public static Node rotateRight_by_k(Node head, int k) { // O(n*k)
        if (head == null || head.next == null)
            return head;
        int n = 0;
        Node temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;

        }
        System.out.println(n);
        k = k % n;

        while (k > 0) {
            head = rotate(head);
            k--;
        }
        return head;

    }

    public static Node rotateRight_by_k_optimal(Node head, int k) { // O(n)
        if (head == null || head.next == null)
            return head;
        int n = 0;
        Node temp = head;

        while (temp != null) {
            n++;
            if (temp.next == null) {
                temp.next = head;
                break;
            }
            temp = temp.next;

        }
        k = k % n;
        int len = n - k - 1;
        temp = head;
        while (len > 0) {
            temp = temp.next;
            len--;
        }
        head = temp.next;
        temp.next = null;
        return head;

    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null && list2 == null)
            return list1;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null)
            tail.next = list1;
        else
            tail.next = list2;

        return dummy.next;
    }

    class Flattern {

        private class Node {
            int data;
            Node next;
            Node bottom;

            public Node(int data) {
                this.data = data;
                this.next = null;
                this.bottom = null;
            }
        }

        public Node compare(Node list1, Node list2) {
            Node dummy = new Node(-1);
            Node temp = dummy;
            while (list1 != null && list2 != null) {
                if (list1.data < list2.data) {
                    temp.bottom = list1;
                    temp = list1;
                    list1 = list1.bottom;
                } else {
                    temp.bottom = list2;
                    temp = list2;
                    list2 = list2.bottom;
                }
                temp.next = null;
            }
            if (list1 == null) {
                temp.bottom = list2;
            } else {
                temp.bottom = list1;
            }
            return dummy.bottom;
        }

        public Node flatten(Node root) {
            // code here
            Node head = root;
            if (head == null || head.next == null)
                return head;

            Node temp = head;
            Node pre = head;
            while (temp.next != null && pre != null) {
                pre = temp.next.next;
                temp = compare(temp, temp.next);
                temp.next = pre;

            }
            return temp;
        }
    }

    class MergeList { // O(n*k)
        public static Node merge(Node list1, Node list2) {
            Node dummy = new Node(-1);
            Node temp = dummy;
            while (list1 != null && list2 != null) {
                if (list1.data < list2.data) {
                    temp.next = list1;
                    temp = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    temp = list2;
                    list2 = list2.next;
                }
                temp.next = null;
            }
            if (list1 == null) {
                temp.next = list2;
            } else {
                temp.next = list1;
            }
            return dummy.next;

        }

        public static Node mergeKLists(Node[] lists) {
            if (lists.length == 0)
                return null;
            if (lists.length == 1)
                return lists[0];
            int k = 0;

            while (k < lists.length - 1) {
                lists[k + 1] = linkedlist_.MergeList.merge(lists[k], lists[k + 1]);
                k++;
            }
            return lists[lists.length - 1];

        }
    }

    public static Node sortList(Node head) { // O(nlogn) SC- O(logn)
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        Node pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        Node right = sortList(slow);
        Node left = sortList(head);
        return MergeList.merge(left, right);

    }

    class copyRandomList {
        public static class Node {
            int val;
            Node next;
            Node random;

            public Node(int data) {
                val = data;
                this.next = null;
                this.random = null;
            }
        }

        public static Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            HashMap<Node, Node> a = new HashMap<>();
            Node temp = head;
            while (temp != null) {
                a.put(temp, new Node(temp.val));
                temp = temp.next;
            }
            temp = head;
            while (temp != null) {
                a.get(temp).next = a.get(temp.next);
                a.get(temp).random = a.get(temp.random);
                temp = temp.next;
            }
            return a.get(head);
        }
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

        // int arr9[]={1,2,3,4,5,6};
        // print(deleteMiddle(createList(arr9)));

        // int arr10[]={1,1,2,3,4,5,5,7,7,7,8};
        // print(deleteDuplicates(createList(arr10)));

        // int arr11[] = { 1, 2 };
        // print(reverseKGroup(createList(arr11), 2));

        // int arr12[] = { 1, 2, 3, 4, 5, 6 };
        // print(rotateRight_by_k(createList(arr12), 7));

        // int arr13[] = { -9, 3 };
        // int arr14[] = { 5, 7 };
        // print(mergeTwoLists(createList(arr13), createList(arr14)));

        // int arr15[]={5,9,-1,3,0};
        // print(sortList(createList(arr15)));

    }
}
