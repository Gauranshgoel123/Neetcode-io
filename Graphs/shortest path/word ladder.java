class Pair{
    String first;
    int second;
    public Pair(String f,int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        q.add(new Pair(begin,1));
        set.remove(begin);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.first;
            int level=p.second;
            if(word.equals(end)) return level;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String transformed=new String(arr);
                    if(set.contains(transformed)){
                        q.add(new Pair(transformed,level+1));
                        set.remove(transformed);
                    }
                }
            }
        }
        return 0;
    }
}
/* 

SC is O(N*L*26)
n is the number of words
l is the length of each word

SC is O(N*L)
n words of each length L in the worst case

*/

