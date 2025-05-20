class State{
    int x,y;
    State(int a, int b){
        this.x=a;
        this.y=b;
    }
}
class Solution{
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y==z) return true;
        if(x+y<z) return false;
        if(x%2==0 && y%2==0 && z%2!=0)//cannot measure odd capacity using even capacity jugs 
            return false;
        
        HashSet<String> visited=new HashSet<>();//state visited hset of jugs
        State start=new State(0,0);
        Queue<State> q=new LinkedList<>();
        q.add(start);
        //run a bfs. don't add already visited states
        while(!q.isEmpty()){
            int n=q.size();
            State curr=q.poll();
            if(curr.x+curr.y==z)
                return true;
            visited.add(curr.x+","+curr.y);
            
            int newY,newX;
            //pour x->y ********************* option 1
            newX=curr.x-Math.min(curr.x,y-curr.y);
            newY=curr.y+Math.min(curr.x,y-curr.y);
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
            
            //pour x<-y ********************* option 2
            newX=curr.x+Math.min(curr.y,x-curr.x);
            newY=curr.y-Math.min(curr.y,x-curr.x);
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
            
            //expty x   ********************* option 3
            newX=0;
            newY=curr.y;//same
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
            
            //empty y   ********************* option 4
            newX=curr.x;//same
            newY=0;
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
            
            //fill x    ********************* option 5
            newX=x;//max capacity
            newY=curr.y;
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
            
            //fill y    ********************* option 6
            newX=curr.x;
            newY=y;//max capacity
            if(!visited.contains(newX+","+newY) )
                q.add(new State(newX,newY));
        }
        return false;
    }
}
