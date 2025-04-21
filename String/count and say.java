RECURSIVE SOLUTION
  
  class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        return helper(countAndSay(n-1));
    }
    private String helper(String s){
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)) cnt++;
            else{
                sb.append(cnt).append(s.charAt(i-1));
                cnt=1;
            }
        }
        sb.append(cnt).append(s.charAt(s.length()-1));
        return sb.toString();

    }
}


ITERATIVE SOLUTION


  class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=0;i<n-1;i++){
            s=helper(s);
        }
        return s;
    }
    private String helper(String s){
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)) cnt++;
            else{
                sb.append(cnt).append(s.charAt(i-1));
                cnt=1;
            }
        }
        sb.append(cnt).append(s.charAt(s.length()-1));
        return sb.toString();

    }
}
  
