public class string {
    public static void palindrome(String a){
        int s=a.length();
        for (int i = 0; i < s/2; i++) {
            if (a.charAt(i)!=a.charAt(s-i-1)) {
                System.out.println("not palindrome");
                return;
            }
          
        }
          System.out.println("palindrome");
    }
    public static void main(String[] args){
       // palindrome("abaa");
    }
}
