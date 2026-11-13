class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] nodesWithIncoming = new boolean[n];

        for(List<Integer> e: edges){
            int v = e.get(1);
            nodesWithIncoming[v] = true;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!nodesWithIncoming[i]) res.add(i);
        }
        return res;
    }
}