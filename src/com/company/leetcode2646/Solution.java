package com.company.leetcode2646;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author awmlk
 */
public class Solution {
    static class Trip {
        String path;
        int price;
    }

    /**
     * 求旅途最少花费
     * 思路：
     * 跟着大佬们学，先深度遍历，求出每个旅途通过的节点各有多少，然后再算在这种节点通过情况下，怎么打折能够最便宜
     * 但是这个有一个小小的问题，就是深度遍历的时候，如果有多条路线，怎么选取，官方题解认为最短路径一定最便宜，但是我觉得不一定
     * 先暂且按当前路径打着前花费最少来做吧
     *
     * @param n     旅途目的地数
     * @param edges 不同目的地连接情况
     * @param price 目的地价格
     * @param trips 旅途起点和终点
     * @return 最小花费
     */
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<Integer>[] childList = new List[n];
        for (int i = 0; i < childList.length; i++) {
            childList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            childList[edge[0]].add(edge[1]);
            childList[edge[1]].add(edge[0]);
        }
        int[] count = searchRoutes(n, childList, price, trips);
        int[] res = dpForTotalMinPrice(new Stack<Integer>(), 0, childList, price, count);
        return Math.min(res[0], res[1]);
    }

    private int[] searchRoutes(int n, List<Integer>[] edges, int[] price, int[][] trips) {
        int[] count = new int[n];
        for (int[] trip : trips) {
            Trip oneTrip = new Trip();
            oneTrip.price = Integer.MAX_VALUE;
            oneTrip.path = "";
            minPriceRoutes(new Stack<Integer>(), edges, price, trip, 0, oneTrip);
            if (!"".equals(oneTrip.path)) {
                String[] routes = oneTrip.path.split("-");
                for (String route : routes) {
                    if ("".equals(route)) {
                        break;
                    }
                    count[Integer.parseInt(route)]++;
                }
            }
        }
        return count;
    }

    private void minPriceRoutes(Stack<Integer> tempRoutes, List<Integer>[] edges, int[] price, int[] trip, int tempPrice, Trip oneTrip) {
        if (tempRoutes.isEmpty()) {
            tempRoutes.add(trip[0]);
            tempPrice = price[trip[0]];
        }
        if (tempPrice >= oneTrip.price) {
            return;
        }
        if (tempRoutes.peek().equals(trip[1])) {
            StringBuilder builder = new StringBuilder();
            for (Integer node : tempRoutes) {
                builder.append(node).append("-");
            }
            oneTrip.path = builder.toString();
            oneTrip.price = tempPrice;
            return;
        }
        for (int next : edges[tempRoutes.peek()]) {
            if (tempRoutes.contains(next)) {
                continue;
            }
            tempRoutes.add(next);
            minPriceRoutes(tempRoutes, edges, price, trip, tempPrice + price[next], oneTrip);
            tempRoutes.pop();
        }
    }

    private int[] dpForTotalMinPrice(Stack<Integer> path, int index, List<Integer>[] edges, int[] price, int[] count) {
        if (path.isEmpty()) {
            path.add(index);
        }
        int[] res = new int[2];
        res[0] = price[index] * count[index];
        res[1] = res[0] / 2;
        for (int child : edges[index]) {
            if (path.contains(child)) {
                continue;
            }
            path.add(child);
            int[] childRes = dpForTotalMinPrice(path, child, edges, price, count);
            path.pop();
            res[0] += Math.min(childRes[0], childRes[1]);
            res[1] += childRes[0];
        }
        return res;
    }
}