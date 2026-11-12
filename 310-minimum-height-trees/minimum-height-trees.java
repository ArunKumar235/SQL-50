class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        
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
        for(int i = 0; i < n; i++){
            if(deg[i] == 1) leaves.offer(i);
        }

        while(n > 2){
            int size = leaves.size();
            n -= size;

            while(size-- > 0){
                int u = leaves.poll();

                for(int v: adj.get(u)){
                    deg[v]--;
                    if(deg[v] == 1) leaves.offer(v);
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}