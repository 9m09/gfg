
class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[adj.size()];
        boolean[] vis = new boolean[adj.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[src]=0;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{src,0});
        vis[src]=true;
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int node=arr[0];
            int d=arr[1];
            for(int i=0;i<adj.get(node).size();i++){
                // if(!vis[adj.get(node).get(i)]){
                //     int curd=Math.min(d+1,dist[adj.get(node).get(i)]);
                //     queue.add(new int[]{adj.get(node).get(i),curd});
                //     dist[adj.get(node).get(i)]=curd;
                //     vis[adj.get(node).get(i)]=true;
                // }
                if(dist[adj.get(node).get(i)]>d+1){
                        queue.add(new int[]{adj.get(node).get(i),d+1});
                        dist[adj.get(node).get(i)]=d+1;
                        vis[adj.get(node).get(i)]=true;
                    // }
                }
            }
            
        }
        
        for(int i=0;i<adj.size();i++){
            if(dist[i]==Integer.MAX_VALUE)    dist[i]=-1;
        }
        
        return dist;
    }
}
