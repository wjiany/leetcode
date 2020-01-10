package com.wjiany.examine;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Welcome to vivo !
 */

public class MainVivo2 {

    static int tmp = 0;
    static BigDecimal cp =new BigDecimal(0);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        int[] isUsed = new int[services.size()];
        Arrays.fill(isUsed,0);
         fun(totalDisk,totalMemory,services,0,isUsed,0);
         return tmp;
    }

    public static void fun(int totalDisk, int totalMemory, List<Service> services,int count,int[] isUsed,int scount){
        if(totalDisk<=0||totalMemory<=0){
            BigDecimal divide = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(scount));
            if(divide.compareTo(cp)>0){
                cp = divide;
                tmp = count;
            }
        }
        for (int i = 0;i<services.size();i++){
            if(isUsed[i] != 1){
                isUsed[i] = 1;
                Service service = services.get(i);
                fun(totalDisk-service.getDisk(),
                        totalMemory-service.getMemory(),
                        services,
                        count+service.getusers(),isUsed,scount+1);
                isUsed[i] = 0;
            }
        }
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}