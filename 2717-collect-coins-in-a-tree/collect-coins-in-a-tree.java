// Bottom-up DP - Aggregate information from descendants
class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        // number of nodes in a tree = number of edges + 1
        int n = edges.length + 1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] deg = new int[n];

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        boolean[] active = new boolean[n];
        Arrays.fill(active, true);

        int[] maxDist = new int[n];
        
        for(int i = 0; i < n; i++){
            if(coins[i] == 1) maxDist[i] = 0;
            else maxDist[i] = -1;

            if(deg[i] == 1) leaves.offer(i);
        }

        while(!leaves.isEmpty()){
            int u = leaves.poll();

            if(maxDist[u] >= 2) continue;

            active[u] = false;
            deg[u]--;

            for(int v: adj.get(u)){
                if(active[v]){
                    if(maxDist[u] != -1){                    
                        maxDist[v] = Math.max(maxDist[v], maxDist[u] + 1);
                    }

                    deg[v]--;
                    if(deg[v] == 1) leaves.offer(v);
                }
            }
        }
        int activeE = 0;
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            if(active[u] && active[v]) activeE++;
        }

        return 2*activeE;

    }
}