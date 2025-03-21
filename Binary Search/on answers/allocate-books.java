import java.util.ArrayList;
public class Solution {

    private static int helper(ArrayList<Integer> arr,int maxpages){
        int stud=1;
        int page=0;
        for(int i=0;i<arr.size();i++){
            if(page+arr.get(i)<=maxpages){
                page+=arr.get(i);
            }
            else{
                stud++;
                page=arr.get(i);
            }
        }
        return stud;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;
        int l=0;
        for(int i=0;i<arr.size();i++){
            l=Math.max(l,arr.get(i));
        }
        int h=0;
        for(int i:arr){
            h+=i;
        }
        while(l<=h){
            int mid=(l+h)/2;
            int noofstud=helper(arr,mid);
            if(noofstud>m){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l;
    }
}
