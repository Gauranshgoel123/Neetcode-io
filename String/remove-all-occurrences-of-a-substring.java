class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int m=part.length();
        char charend=part.charAt(m-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            sb.append(ch);
            if(ch==charend){
                int sbidx=sb.length()-1;
                int partidx=m-1;
                while(sbidx >= 0 && partidx >= 0 && sb.charAt(sbidx)==part.charAt(partidx)){
                    sbidx--;
                    partidx--;
                }
                if(partidx<0){
                    sb.delete(sb.length()-m,sb.length());
                }
            }
        }
        return sb.toString();
    }
}


class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.indexOf(part)!=-1){
            int idx=sb.indexOf(part);
            sb.delete(idx,idx+part.length());
        }
        return sb.toString();
    }
}
