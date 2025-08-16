class Solution {
    // Function to return Breadth First Traversal of given graph.
    int timer=0;
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
      
        ArrayList<Integer> con = new ArrayList<>();
        int[] art=new int[V];
        int[] time = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        dfs(0,vis,time,low,adj,-1,con,art);
        
        for(int i =0;i<V;i++){
            if(art[i]==1)   con.add(i);
        }
        if(con.size()==0)   {con.add(-1);return con;}
        Collections.sort(con);
        
        return con;
        
        
    }
     void dfs(int start,boolean[] vis,int[] time,int[] low,ArrayList<ArrayList<Integer>> adj,int parent,ArrayList<Integer> con,int[] art){
        
        vis[start]=true; 
        timer++;
        low[start]=timer;
        time[start]=timer;
        int child=0;
        for(int i=0;i<adj.get(start).size();i++){
            if(adj.get(start).get(i)==parent)   continue;
            if(!vis[adj.get(start).get(i)]){
                child++;
                dfs(adj.get(start).get(i),vis,time,low,adj,start,con,art);
                low[start]=Math.min(low[start],low[adj.get(start).get(i)]);
                if(time[start]<=low[adj.get(start).get(i)] && parent!=-1){
                    // ArrayList<Integer> list = new ArrayList<>();
                    // list.add(start);
                    // list.add(adj.get(start).get(i));
                        // con.add(start);
                    art[start]=1;
                    // con.add(start);
                }
            }
            else    
            low[start]=Math.min(low[start],time[adj.get(start).get(i)]);
        }
        
        if (child > 1 && parent == -1) {
            art[start] = 1;
            // con.add(start);
        }
        
    }
}
