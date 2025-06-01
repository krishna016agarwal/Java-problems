

public class pattern {

  public static void draw(int n){
    for (int i = 0; i < 2*n-1; i++) {
      for (int j = 0; j < 2*n-1; j++) {
        int min=Math.min(Math.min(i,j),Math.min(2*n-2-j,2*n-2-i));
        System.out.print(n-min +" ");
      }
        System.out.println();
    }
  
  }
    public static void main(String[] args) {
   
draw(3);
       
    }
}
