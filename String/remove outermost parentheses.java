class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(!stack.isEmpty()){
                    ans.append('(');
                }
                stack.push('(');
            }
            else{
                stack.pop();
                if(!stack.isEmpty()){
                    ans.append(')');
                }
            }
        }
        return ans.toString();
    }
}


class Solution {
    public String removeOuterParentheses(String s) {
        if(s=="") return "";
        int open=1;
        StringBuilder ans=new StringBuilder();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
                if(open>1) ans.append('(');
            }
            else{
                open--;
                if(open>0) ans.append(')');
            }
        }
        return ans.toString();
    }
}
