class Solution {
    public String frequencySort(String s) {
        int[] freq=new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        char[] res=new char[s.length()];
        int i=0;
        while(i<s.length()){
            int maxi=findMaxI(freq);
            int f=freq[maxi];
            while(f>0){
                res[i++]=(char)(maxi);
                f--;
            }
            freq[maxi]=0;
        }
        return new String(res);
    }
    private int findMaxI(int[] arr){
        int maxi=0;
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                maxi=i;
                max=arr[i];
            }
        }
        return maxi;
    }
}
