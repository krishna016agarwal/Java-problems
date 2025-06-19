import java.util.*;
public class stack {
    static class stackB{
        static ArrayList<Integer> a=new ArrayList<>();
        public static boolean isEmpty(){
            if (a.size()==0) {
                return true;
            }
            return false;
        }
        public static void push(int data){
            a.add(data);
        }
        public static int pop(){
            int top=a.get(a.size()-1);
            a.remove(a.size()-1);
            return top;
        }
         public static int peek(){
         return a.get(a.size()-1);
        }
    }
    public static void main(String args[]) {
stackB s=new stackB();
stackB.push(1);
stackB.push(2);
stackB.push(3);
stackB.push(4);
while (!stackB.isEmpty()) {
    System.out.println(stackB.peek());
    stackB.pop();
}
    }
    }
