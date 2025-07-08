import java.util.*;
public class hashMap {
   
    public static void frequencyOfElements(int arr[]){
        HashMap<Integer,Integer> map=new HashMap();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
               map.put(arr[i],map.get(arr[i])+1) ;
            }else{
                map.put(arr[i],1) ;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])!=0) {
                 System.out.println(arr[i]+"->"+map.get(arr[i]));
            }
           
            map.put(arr[i],0);
        }

    }

    public static void main(String[] args){
int arr[]={1,2,1,3,3,5,1};
frequencyOfElements(arr);
    }
}
