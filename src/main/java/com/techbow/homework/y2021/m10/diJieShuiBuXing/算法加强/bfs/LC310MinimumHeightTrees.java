package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.*;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * Example 3:
 *
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 4:
 *
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated edges.
 */


public class LC310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //cc
        List<Integer> res = new ArrayList<>();
        if(edges == null || edges.length == 0 || edges[0] == null || n <=1){
            res.add(0);
            return res;
        }

        //construct graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            graph.computeIfAbsent(edge[0], s->new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], s->new HashSet<>()).add(edge[0]);
        }

        int nodes = n;
        Queue<Integer> queue = new LinkedList<>();
        // find nodes who has only 1 neighbor
        for(int i = 0; i < n ; i++){
            if(graph.get(i).size() == 1){
                queue.offer(i);
                nodes--;
            }
        }

        while(nodes>0){
            int size = queue.size();
            while(size-- > 0){
                int cur = queue.poll();

                for(int nei:graph.get(cur)){
                    graph.get(nei).remove(cur);
                    if(graph.get(nei).size() == 1){
                        queue.offer(nei);
                        nodes--;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
