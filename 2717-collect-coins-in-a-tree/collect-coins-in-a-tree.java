// Leaf pruning - Eliminate irrelevant nodes
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

        // Phase 1: Removing the zero coin leaf nodes (cascading)
        Queue<Integer> leaves = new LinkedList<>();
        boolean[] removed = new boolean[n];

        for(int i = 0; i < n; i++){
            if(deg[i] == 1 && coins[i] == 0) leaves.offer(i);
        }

        while(!leaves.isEmpty()){
            int u = leaves.poll();
            removed[u] = true;

            for(int v: adj.get(u)){
                deg[v]--;
                if(deg[v] == 1 && coins[v] == 0) leaves.offer(v);
            }
        }

        // Phase 2: Trim two layers of leaves of the pruned subtree
        // irrespective of it has coins or not
        for(int step = 0; step < 2; step++){
            Queue<Integer> q = new LinkedList<>();
            
            for(int i = 0; i < n; i++){
                if(!removed[i] && deg[i] == 1) q.offer(i);
            }

            while(!q.isEmpty()){
                int u = q.poll();
                removed[u] = true;

                for(int v: adj.get(u)){
                    if(!removed[v]){
                        deg[v]--;
                    }
                }
            }
        }

        int remNodes = 0;
        for(int i = 0; i < n; i++){
            if(!removed[i]) remNodes++;
        }

        return Math.max(0, (remNodes - 1) * 2);
    }
}