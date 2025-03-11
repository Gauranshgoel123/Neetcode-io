MOST OPTIMAL USING SLIDING WINDOW

class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        int[] lastseen={-1,-1,-1};
        for(int i=0;i<n;i++){
            lastseen[s.charAt(i)-'a']=i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                cnt=cnt+(1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2])));
            }
        }
        return cnt;
    }
}

BRUTE FORCE

class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


OPTIMAL BRUTE FORCE

class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    cnt=cnt+(n-j);
                    break;
                }
            }
        }
        return cnt;
    }
}
