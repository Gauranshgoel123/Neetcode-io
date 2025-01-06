class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr=new int[26];
        if(s1.length()>s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']--;
            arr[s2.charAt(i)-'a']++;
        }
        if(isallzero(arr)) return true;

        for(int i=s1.length();i<s2.length();i++){
            arr[s2.charAt(i)-'a']++;
            arr[s2.charAt(i-s1.length())-'a']--;
            if(isallzero(arr)) return true;
        }
        return false;
    }
    private boolean isallzero(int[] arr){
        for(int i:arr){
            if(i!=0) return false;
        }
        return true;
    }
}
