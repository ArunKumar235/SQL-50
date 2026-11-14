class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();

        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(dfs(i, graph, visited)) res.add(i);
        }
        return res;
    }
    
    // visited[i] = 0 -> yet to explore
    // visited[i] = 1 -> cycle detected
    // visited[i] = 2 -> fully explored

    private boolean dfs(int node, int[][] graph, int[] visited){
        if(visited[node] == 2) return true;

        if(visited[node] == 1) return false;

        visited[node] = 1;
        for(int v : graph[node]){
            if(!dfs(v, graph, visited)) return false;
        }
        visited[node] = 2;
        return true;
    }
}