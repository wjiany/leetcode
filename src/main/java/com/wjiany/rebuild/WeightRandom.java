package com.wjiany.rebuild;

import org.junit.Test;

import java.util.*;

/**
 * 带权重负载均衡
 */

public class WeightRandom {

    @Test
    public void testRandom(){
        for (int i = 1;i<=20;i++){
            System.out.println(getResponseByWeightRandom());
        }
    }


    public static Map requestPool;
    static {
        requestPool = new HashMap<String, Integer>();
        requestPool.put("a", 10);
        requestPool.put("b", 10);
        requestPool.put("c", 10);
        requestPool.put("d", 10);
        requestPool.put("e", 10);
    }

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
}
