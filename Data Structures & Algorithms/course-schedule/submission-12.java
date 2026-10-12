class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][0], trgt = prerequisites[i][1];
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }

            if (!adjList.containsKey(trgt)) {
                adjList.put(trgt, new ArrayList<>());
            }

            adjList.get(src).add(trgt);
        }

        HashSet<Integer> visit = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, visit)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(Integer start, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visit) {
        if (visit.contains(start) ) {
            return false;
        }
        if (map.get(start) == null || map.get(start).size() == 0) {
            return true;
        }
        visit.add(start);
        for (Integer neighbor : map.get(start)) {
            if (!dfs(neighbor, map, visit)) return false;
        }
        visit.remove(start);
        map.put(start, new ArrayList<>());
        return true;
    }
}
