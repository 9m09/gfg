class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int v=adj.size();
        boolean[] vis =  new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
            vis[0]=true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            list.add(temp);
            for(int i=0;i<adj.get(temp).size();i++){
                if(vis[adj.get(temp).get(i)]!=true){
                    vis[adj.get(temp).get(i)]=true;
                    queue.add(adj.get(temp).get(i));
                }
            }
            
        }
        
        return list;
    }
}