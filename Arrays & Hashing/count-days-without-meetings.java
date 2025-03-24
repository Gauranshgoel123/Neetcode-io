class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> Integer.compare(a[0],b[0]));
        int total=0;
        int start=meetings[0][0];
        int end=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            int currstart=meetings[i][0];
            int currend=meetings[i][1];
            if(currstart<=end){
                end=Math.max(end,currend);
            }
            else{
                total+=(end-start+1);
                start=currstart;
                end=currend;
            }
        }
        total+=(end-start+1);
        return days-total;
    }
}
