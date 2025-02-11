class Data {
    public String key;
    public String value;
    public int timestamp;

    public Data(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private ArrayList<Data> arr;

    public TimeMap() {
        arr = new ArrayList<>();
    }

    public void set(String key, String value, int timestamp) {
        arr.add(new Data(key, value, timestamp));
    }

    public String get(String key, int timestamp) {
        // Note: Could use binary search for O(logN) search
        // Note: This also assumes that the set operation with increasing based on
        // the provided constraint:
        // - All the timestamps timestamp of set are strictly increasing.
        for (int i = arr.size() - 1; i >= 0; i--) {
            var tri = arr.get(i);
            if (tri.timestamp <= timestamp && tri.key.equals(key)) {
                return tri.value;
            }
        }
        return "";

    }
}



class TimeMap {

    private HashMap<String,ArrayList<Pair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(timestamp,value));
        }
        else{
            ArrayList<Pair> arr=new ArrayList<>();
            arr.add(new Pair(timestamp,value));
            map.put(key,arr);
        }
    }
    
    public String get(String key, int timestamp) {
        String temp="";
        if(map.containsKey(key)){
            ArrayList<Pair> arr=map.get(key);
            int l=0;
            int r=arr.size()-1;
            while(l<=r){
                int m=l+(r-l)/2;
                int time=arr.get(m).timestamp;
                if(time==timestamp){
                    return arr.get(m).value;
                }
                else if(time<timestamp){
                    temp=arr.get(l).value;
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
        }
        return temp;
    }   
}

class Pair{

    int timestamp;
    String value;
    Pair(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
