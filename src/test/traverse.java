package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: fl
 * @data: 2020-06-18 15:27
 * @description: 遍历图
 **/
public class traverse {

    // 记录所有路径
    static List<List<Integer>> res = new LinkedList<>();


    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {2}, {3}, {}};
        allPathsSourceTarget(graph);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    static void traverse(int[][] graph,
                         int s,
                         LinkedList<Integer> path) {

        // 添加节点 s 到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        int[] ints = graph[s];
        for (int v : ints) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.removeLast();
    }

}

