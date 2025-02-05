class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int diff=0;
        int firstdiff=0;
        int seconddiff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>2) return false;
                else if(diff==1) firstdiff=i;
                else seconddiff=i;
            }
        }
        if(s1.charAt(firstdiff)==s2.charAt(seconddiff) && s1.charAt(seconddiff)==s2.charAt(firstdiff)){
            return true;
        }    
        return false;   
    }
}

//abcd
//dcba
