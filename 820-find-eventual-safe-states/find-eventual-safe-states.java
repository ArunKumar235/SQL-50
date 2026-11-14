class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < n; i++) revAdj.add(new ArrayList<>());

        int[] outgoings = new int[n];
        for(int u = 0; u < n; u++){
            for(int v: graph[u]){
                revAdj.get(v).add(u);
                outgoings[u]++;
            }
        }

        Queue<Integer> noOutgoing = new LinkedList<>();
        for(int u = 0; u < n; u++){
            if(outgoings[u] == 0) noOutgoing.offer(u);
        }

        while(!noOutgoing.isEmpty()){
            int v = noOutgoing.poll();

            for(int u : revAdj.get(v)){
                outgoings[u]--;
                if(outgoings[u] == 0) noOutgoing.offer(u);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int u = 0; u < n; u++) if(outgoings[u] == 0) res.add(u);
        return res;
    }
}