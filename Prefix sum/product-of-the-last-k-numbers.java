class ProductOfNumbers {
    private List<Integer> prefprod;

    public ProductOfNumbers() {
        prefprod=new ArrayList<>();
        prefprod.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefprod=new ArrayList<>();
            prefprod.add(1);
        }
        else{
            prefprod.add(prefprod.get(prefprod.size()-1)*num);
        }
    }

    public int getProduct(int k) {
        int size=prefprod.size();
        return (k>=size) ? 0 : prefprod.get(size-1)/prefprod.get(size-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */





  BRUTE FORCE


class ProductOfNumbers {
    private List<Integer> nums;

    public ProductOfNumbers() {
        nums=new ArrayList<>();
    }
    
    public void add(int num) {
        nums.add(num);        
    }
    
    public int getProduct(int k) {
        int prod=1;
        int n=nums.size();
        for(int i=n-k;i<n;i++){
            prod*=nums.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
