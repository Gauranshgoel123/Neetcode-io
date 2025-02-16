MOST OPTIMAL SOLUTION


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=n1;
        int left=(n1+n2+1)/2;
        int len=n1+n2;
        while(low<=high){
            int mid1=low-(low-high)/2;
            int mid2=left-mid1;
            int l1 = (mid1>0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2>0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1<n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2<n2) ? nums2[mid2] : Integer.MAX_VALUE;
            if(l1>r2){
                high=mid1-1;
            }
            else if(l2>r1){
                low=mid1+1;
            }
            else{
                if(len%2==0){
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return (double) Math.max(l1,l2);
                }
            }
        }
        return 0;
    }
}


BRUTE FORCE

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int m=nums1.length;
        int n=nums2.length;
        List<Integer> merged=new ArrayList<>();
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                merged.add(nums1[i++]);
            }
            else{
                merged.add(nums2[j++]);
            }
        }
        while(i<m){ //some elements might be left of nums1
            merged.add(nums1[i++]);
        }
        while(j<n){ //some elements might be left of nums2
            merged.add(nums2[j++]);
        }
        int len=m+n;
        if(len%2==0){
            ans=( (double) merged.get(len/2)+ (double) merged.get((len/2)-1))/2;
        }
        else ans= (double) merged.get(len/2);
        return ans;
    }
}


SPACE OPTIMIZATION


  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        int idx2=len/2;
        int idx1=idx2-1;
        int cnt=0;
        int i=0,j=0;
        int ele1=0;
        int ele2=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                if(cnt==idx1) ele1=nums1[i];
                if(cnt==idx2) ele2=nums1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==idx1) ele1=nums2[j];
                if(cnt==idx2) ele2=nums2[j];
                cnt++;
                j++;
            }
        }
        while(i<m){ //some elements might be left of nums1
            if(cnt==idx1) ele1=nums1[i];
            if(cnt==idx2) ele2=nums1[i];
            cnt++;
            i++;
        }
        while(j<n){ //some elements might be left of nums2
            if(cnt==idx1) ele1=nums2[j];
            if(cnt==idx2) ele2=nums2[j];
            cnt++;
            j++;
        }
        if(len%2==0){
            ans=( (double) (ele1+ele2)/2 );
        }
        else ans= (double) ele2;
        return ans;
    }
}


