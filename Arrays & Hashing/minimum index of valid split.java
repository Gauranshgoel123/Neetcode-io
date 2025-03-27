class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<nums.size();j++){
            map.put(nums.get(j),map.getOrDefault(nums.get(j),0)+1);
        }
        int total=nums.size();
        int dom=-1;
        for(int k:map.keySet()){
            if(map.get(k)>total/2){
                dom=k;
            }
        }
        if(dom==-1) return -1;
        int domcount=map.get(dom);
        int cnt=0;
        for(int i=0;i<nums.size();i++){
            int len1=i+1;
            int len2=total-len1;
            if(nums.get(i)==dom) cnt++;
            if((cnt>len1/2) && (domcount-cnt)>len2/2) return i;
        }
        return -1;
    }
}
