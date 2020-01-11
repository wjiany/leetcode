package com.wjiany.rebuild.algorithm.loadbalance;

import org.junit.Test;

import java.util.*;

/**
 * 带权重负载均衡
 */

public class WeightObjRandom {

    @Test
    public void testRandom(){
        for (int i = 1;i<=10;i++){
            System.out.println(getResponseByWeightCurrent());
        }
    }


    public static Map requestPool;
    static {
        requestPool = new HashMap<String, Integer>();
        requestPool.put("a", 3);
        requestPool.put("b", 1);
        requestPool.put("c", 1);
        //requestPool.put("d", 1);
       // requestPool.put("e", 1);
    }

    /**
     * 随机
     * @return
     */
    public String getResponseByRandom() {
        return (String) requestPool.keySet().toArray()[new Random().nextInt(requestPool.size())];
    }

    /**
     * 根据权重 进行随机轮询  Robin
     * @return
     */
    public String getResponseByWeightRandom() {
        int totalWeight = 0;
        boolean flag = true;//是否权重相同 ，相同的话，直接随机
        Object[] values = requestPool.values().toArray();
        for (Object value :values) {
            totalWeight += (Integer) value;
            if (flag && value != values[0]){
                flag = false;
            }
        }


        Random random = new Random();
        int anInt = random.nextInt(totalWeight);

        if (!flag){
            Set<Map.Entry<String,Integer>> entrySet = requestPool.entrySet();
            for (Map.Entry<String,Integer> entry :entrySet) {
                if(anInt < entry.getValue()){
                    return entry.getKey();
                }
                anInt -= entry.getValue();
            }
        }
        return (String) requestPool.keySet().toArray()[random.nextInt(requestPool.size())];
    }

    /**
     * 根据 加权 进行平滑的轮询 比如 AAABC，平滑后为ABACA
     *
     * 避免根据权重随机，导致权重大的机器连续处理请求
     * @return
     */
    private static Map<String, WeightObj> weightObjMap = new HashMap<>();

    public String getResponseByWeightCurrent() {
        //总权重
        int totalWeight = (int)requestPool.values().stream().reduce(0, (v1, v2) -> (int) v1 + (int) v2);
        //初始化权重 ip ，（IP，自身weigth，变化weight）
        if(weightObjMap.isEmpty()){
            requestPool.forEach((ip,value)->{
                weightObjMap.put((String) ip,new WeightObj((String)ip,(Integer) value,(Integer) value));
            });
        }
        //找最大当前权重，它的ip可以直接返回了
        WeightObj maxWeightObj = null;
        for (WeightObj weightObj:weightObjMap.values()) {
            if(maxWeightObj == null || maxWeightObj.getCurrentWeight() < weightObj.getCurrentWeight()){
                maxWeightObj = weightObj;
            }
        }
        //后面减去最大权重 再加上自身权重，是为了下次使用，实现平滑
        //当前最大权重者，减去总权重
        maxWeightObj.setCurrentWeight(maxWeightObj.getCurrentWeight() - totalWeight);
        //将所有的当前的权重加上自身的权重，为下次的当前权重
        for (WeightObj weightObj : weightObjMap.values()){
            weightObj.setCurrentWeight(weightObj.getWeight() + weightObj.getCurrentWeight());
        }

        return maxWeightObj.getIp();
    }

    /**
     * 哈希一致性算法 https://blog.csdn.net/cb_lcl/article/details/81448570
     */
}
