class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        // System.out.println(adj);
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        boolean flag=false;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                flag = dfs(vis,path,i,adj);
                if(flag==true)  return true;
            }
        }
        return false;
    }
    boolean dfs(boolean[] vis,boolean[] path,int start,ArrayList<ArrayList<Integer>> adj){
        // if(path[start]==true)   return true;
        vis[start]=true;
        path[start]=true;
        for(int i=0;i<adj.get(start).size();i++){
            if(path[adj.get(start).get(i)])    return true;
            else if(!vis[adj.get(start).get(i)]){ 
                if(dfs(vis,path,adj.get(start).get(i),adj)) return true;
            }
            path[adj.get(start).get(i)]=false;
        }
        path[start]=false;
        return false;
    }
}