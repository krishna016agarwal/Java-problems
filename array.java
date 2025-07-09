import java.util.*;

public class array {

    public static int secondLargest(int arr[]) {
        int lar = arr[0];
        int secLar = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lar) {
                secLar = lar;
                lar = arr[i];
            } else if (arr[i] > secLar && arr[i] < lar) {
                secLar = arr[i];
            }
        }
        return secLar;

    }

    public static int remove_duplicate_in_sorted_array(int arr[]) {
        // Deque<Integer> q = new LinkedList<>();
        // for (int i = 0; i < arr.length; i++) {
            
        //     if (q.peek()!=null && q.peekLast() != arr[i]) {
        //         q.add(arr[i]);
        //     }else if(q.peek()==null){
        //         q.add(arr[i]);
        //     }

        // }
        // int size=q.size();
        // for (int i = 0; i < arr.length; i++) {
        //     if (!q.isEmpty()) {
        //         arr[i] = q.remove();
        //     } else {
        //         arr[i] = 0;
        //     }

        // }
        // for (int i = 0; i < size; i++) {
        //     System.out.print(arr[i]+" ");
        // }
        // return size;

        //------------------------------------------
        
        int j=0;
        if(arr.length==0) return 0;
        if(arr.length==1) return 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j]!=arr[i]) {
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }

   public static void rotateArray(int arr[],int k){
 
   if (arr.length==0 || arr.length==1 ||k==0) {
    return;
   }
 
   if (arr.length%2==0 && k%2==0) {
    int i=0;
    while (i<k) {
        int temp=arr[i];
        arr[i]=arr[(i+k)%arr.length];
        arr[(i+k)%arr.length]=temp;
        i++;
    }
    
    return;
   }
     int temp=arr[0];
    int next=k%arr.length;
     while (temp!=arr[next]) {
      
        temp=(temp)+(arr[next]);
    arr[next]=(temp)-(arr[next]);
    temp=(temp)-(arr[next]);
    next=(next+3)%arr.length;

     }
 
   

   }
   
    public static void main(String[] args) {
        // int arr[] = { 1,1,2,2,2, 2, 7, 7 };
        // System.out.println(secondLargest(arr));

        //  int arr[] = { 1,1,2,2,2, 2, 7, 7,8,8,9,10,10 };
       // remove_duplicate_in_sorted_array(arr);
        // System.out.println(remove_duplicate_in_sorted_array(arr));
        
        int arr[]={-1,-100,3,99};
        rotateArray(arr,2);
        for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i]+" ");
   }
    }
}
