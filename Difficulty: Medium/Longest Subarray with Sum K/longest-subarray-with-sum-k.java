// User function Template for Java
class Solution {
    public int longestSubarray(int[] a, int k) {
        
        int n = a.length; 
        
        Map<Integer, Integer> preSumMap = new HashMap<>();      // prefixsum value placed, index
        
        int psum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            psum += a[i];

            // if the sum = k, update the maxLen:
            if (psum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = psum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(psum)) {
                preSumMap.put(psum, i);
            }
        }

        return maxLen;
    }
}
