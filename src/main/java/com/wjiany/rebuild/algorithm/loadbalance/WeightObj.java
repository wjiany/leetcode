package com.wjiany.rebuild.algorithm.loadbalance;

public class WeightObj {
    private String ip;
    private Integer weight;//自身固定权重值
    private Integer currentWeight;  //变化权重

    public WeightObj(String ip, Integer weight, Integer currentWeight){
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
