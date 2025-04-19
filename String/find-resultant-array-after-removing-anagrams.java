class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans=new ArrayList<>();
        ans.add(words[0]);
        String prevsorted=sort(words[0]);

        for(int i=1;i<words.length;i++){
            String currsorted=sort(words[i]);
            if(!currsorted.equals(prevsorted)){
                ans.add(words[i]);
                prevsorted=currsorted;
            }
        }

        return ans;
    }
    private String sort(String s){
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
