package com.example.other;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2023-02-08
 */
public class ThreeDoors {

    private static class Door {
        private Boolean reward;
        private Integer number;

        public Door() {
        }

        public Boolean getReward() {
            return reward;
        }

        public void setReward(Boolean reward) {
            this.reward = reward;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }


    public static void main(String[] args) throws InterruptedException {
//
//        int countSuccess = 0;
//        int countFail = 0;
//        for (int i = 0; i < 1000; i++) {
//            List<Door> doors =  generateDoors();
//            Thread.sleep(5);
//            int[] indexes = pick(doors);
//
//            Boolean res = judge(doors, indexes);
//            if (res) {
//                countSuccess++;
//            } else {
//                countFail++;
//            }
////            System.out.println(res);
//        }
//        System.out.println(countSuccess);
//        System.out.println(countFail+countSuccess);
//
//        Map<Character, Integer> map = new HashMap<>();
//        map.keySet().size();
//        Set<Integer> set = new HashSet<>();
//        set.remove(1);
        String a = "0123456";
        System.out.println(a.substring(0,5));
    }

    public static int[] pick(List<Door> doors){
        Random random  = new Random(System.currentTimeMillis());
        int pickIndex = Math.abs(random.nextInt()) / 10 % 3;
//        System.out.println("pickIndex : " + pickIndex);

        int otherIndex = getRandomDoor(doors, pickIndex);
//        System.out.println("otherIndex : " + otherIndex);
        return new int[]{pickIndex, otherIndex};
    }

    public static Boolean judge(List<Door> doors, int[] indexes) {

        int pickIndex = indexes[0];
        int otherIndex = indexes[1];

        for (Door door : doors) {
            if (door.getNumber().equals(pickIndex) || door.getNumber().equals(otherIndex)) {
                continue;
            }
            if (door.getReward()) {
                return true;
            }
        }
        return false;
    }

    public static int getRandomDoor(List<Door> doors, int initIndex){
        List<Integer> goatIndex = new ArrayList<>();
        for (Door door : doors) {
            if (door.getNumber().equals(initIndex) || door.getReward()) {
                continue;
            }
            goatIndex.add(door.number);
        }
        if (goatIndex.size() == 1) {
            return goatIndex.get(0);
        }
        return goatIndex.get(Math.abs(new Random(System.currentTimeMillis()).nextInt()) % 2);
    }

    public static List<Door> generateDoors() {
        List<Door> doors = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>(3);

        while (indexList.size() < 3) {
            Random random  = new Random(System.currentTimeMillis());
            int index = Math.abs(random.nextInt()) / 10 % 3;
            if (indexList.contains(index)) {
                continue;
            }
            indexList.add(index);
        }
        boolean reward = true;
        for (Integer integer : indexList) {
            Door door = new Door();
            door.setNumber(integer);
            if (reward) {
                door.setReward(reward);
                reward = false;
//                System.out.println("reward : " + integer);
                doors.add(door);
                continue;
            }
            door.setReward(false);

            doors.add(door);
        }
        return doors;
    }

}
