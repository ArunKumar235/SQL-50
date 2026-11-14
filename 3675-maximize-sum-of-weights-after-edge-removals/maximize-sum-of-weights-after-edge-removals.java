// We are NOT greedily choosing the edges with the highest weights, because
// selecting an edge also changes the optimal solution inside its child's subtree
class Solution {
    int k;
    List<List<int[]>> adj;
    long[][] dp;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        this.k = k;
        int n = edges.length+1;
        
        this.adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // dp[node][key]
        this.dp = new long[n][2];
        for(long[] row: dp) row[0] = row[1] = -1L;

        return dfs(0, -1, 0);
    }

    // key = 0 -> edge between parent and node not selected
    // key = 1 -> edge between parent and node selected
    private long dfs(int node, int par, int key){
        if(dp[node][key] != -1) return dp[node][key];

        long ans = 0;
        List<Long> gains = new ArrayList<>();

        for(int[] edge : adj.get(node)){
            int next = edge[0];
            int w = edge[1];

            if(next == par) continue;

            long take = w + dfs(next, node, 1);
            long notTake = dfs(next, node, 0);
            
            // notTake already contains the optimal answer for the child's entire subtree
            ans += notTake;

            if(take - notTake > 0) gains.add(take - notTake);
        }

        gains.sort(Collections.reverseOrder());
        
        int capacity = k - key;
        for(int i = 0; i < Math.min(capacity, gains.size()); i++){
            // replacing the notTake answer with take by adding the difference
            ans += gains.get(i);
        }
        return dp[node][key] = ans;
    }
}