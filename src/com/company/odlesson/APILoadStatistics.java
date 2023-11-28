package com.company.odlesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author awmlk
 * 某个产品的RESTFUL API集合部署在服务器集群的多个节点上，近期对客户端访问日志进行了采集，需要统计各个API的访问频次，
 * 根据热点信息在服务器节点之间左负载均衡，现在需要实现热点信息统计查询功能
 * RestFul API由多个层级构成，层级之间使用/连接，如/A/B/C/D这个地址，A属于第一级，B属于第二级，C属于第三级，D属于第四级
 * 现在负载均衡模块需要知道给定层级上某个名字 出现的频次，未出现过用0表示，实现这个功能
 */
public class APILoadStatistics {
    /**
     * 统计指定层级出现某个名称的次数
     *
     * @param visitNum 总的访问api的数量
     * @param routes 访问api的集合
     * @param layer 层级
     * @param keyword 查询名称
     * @return 指定层级出现某个名称的次数
     */
    public int calApiLoad(int visitNum, List<String> routes, int layer, String keyword) {
        Map<Integer, Map<String, Integer>> apiRoutesMap = new HashMap<>();
        for (String route : routes) {
            String[] keys = route.split("/");
            for (int i = 0; i < keys.length; i++) {
                if (!apiRoutesMap.containsKey(i)) {
                    apiRoutesMap.put(i, new HashMap<>());
                }
                Map<String, Integer> oneLayerMap = apiRoutesMap.get(i);
                oneLayerMap.put(keys[i], oneLayerMap.getOrDefault(keys[i], 0) + 1);
            }
        }
        if (!apiRoutesMap.containsKey(layer)) {
            return 0;
        }
        return apiRoutesMap.get(layer).getOrDefault(keyword, 0);
    }
}
