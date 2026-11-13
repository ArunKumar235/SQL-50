// Leaf Pruning - Layer based BFS
class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        // Radius: Minimum possible maximum distance from a node to every other node.
        // Diameter: Maximum distance between any two nodes.

        int[] tree1 = findRadii(edges1, n1);
        int[] tree2 = findRadii(edges2, n2);
        
        int r1 = tree1[0];
        int r2 = tree2[0];

        int d1 = tree1[1];
        int d2 = tree2[1];

        return Math.max(
            Math.max(d1, d2), 
            r1 + 1 + r2
        );
    }

    private int[] findRadii(int[][] edges, int n){
        if(n == 1) return new int[]{0, 0};
        if(n == 2) return new int[]{1, 1};

        List<List<Integer>> adj = new ArrayList<>();
        int[] deg = new int[n];

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }

        int radius = 0;

        Queue<Integer> leaves = new LinkedList<>();
        
        for(int i = 0; i < n; i++) if(deg[i] == 1) leaves.offer(i);

        while(n > 2){
            int size = leaves.size();
            n -= size;
            radius++;

            while(size-- > 0){
                int u = leaves.poll();
                deg[u]--;

                for(int v: adj.get(u)){
                    if(deg[v] > 0){
                        deg[v]--;
                        if(deg[v] == 1) leaves.offer(v);
                    }
                }
            }
        }
        int diameter = 2 * radius + (n == 2 ? 1 : 0);
        
        return new int[]{radius + (n == 2 ? 1 : 0), diameter};
    }
}