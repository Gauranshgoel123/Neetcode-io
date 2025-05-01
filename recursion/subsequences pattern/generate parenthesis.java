maintain open andclosed bracket count, analyze condiitons when open can be added, when closed and when valid to stop, recurse accordingly



class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        recur(0,0,n,"",ans);
        return ans;
    }
    private void recur(int open,int closed,int n,String s,List<String> ans){
        if(open==closed && closed==n){
            //valid and base condition, add and return 
            ans.add(s);
            return;
        }
        if(open<n){
            //add open bracket
            recur(open+1,closed,n,s+"(",ans);
        }
        if(closed<open){
            //add closed bracket
            recur(open,closed+1,n,s+")",ans);
        }
    }
}
