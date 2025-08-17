import java.util.*;
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0}); 
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue; 
            if (u + 1 < n) {
                int newCost = dist[u] + Math.abs(height[u] - height[u+1]);
                if (newCost < dist[u+1]) {
                    dist[u+1] = newCost;
                    pq.add(new int[]{u+1, newCost});
                }
            }

            if (u + 2 < n) {
                int newCost = dist[u] + Math.abs(height[u] - height[u+2]);
                if (newCost < dist[u+2]) {
                    dist[u+2] = newCost;
                    pq.add(new int[]{u+2, newCost});
                }
            }
        }
        return dist[n-1];
    }

}
