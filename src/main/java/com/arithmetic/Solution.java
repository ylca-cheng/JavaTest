package com.arithmetic;

import org.junit.Test;

import java.util.*;

public class Solution {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap();
        map.put(target-nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else{
                map.put(target-nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,7,11,15};
//        System.out.println(twoSum(nums,14));

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(nums1);


    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
        int p1=m-1,p2 = n-1;
        int tail = m+n-1; //nums1最后的下标
        int cur;
        while(p1 >= 0 || p2 >= 0){
            if(p1 == -1){
                cur = nums2[p2--];
            }else if(p2 == -1){
                cur = nums1[p1--];
            }else if(nums1[p1] > nums2[p2]){
                cur = nums1[p1--];
            }else{
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
     * 可以不考虑输出结果的顺序。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>(nums1.length);
        for(int num1 : nums1){
            if(map.containsKey(num1)){
                map.put(num1,map.get(num1)+1);
            }else{
                map.put(num1,1);
            }
        }
        int index = 0;
        for(int num2 : nums2){
            if(map.containsKey(num2)){
                int num = map.get(num2);
                if(num > 0){
                    nums1[index++] = num2;
                    map.put(num2,--num);
                }
            }
        }
        return Arrays.copyOf(nums1,index);
    }

    @Test
    public void testIntersect(){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] nums = intersect(nums1,nums2);
        System.out.println(nums);
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPro = 0;
        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }else if(price - minPrice > maxPro){
                maxPro = price - minPrice;
            }
        }
        return maxPro;
    }

    @Test
    public void testMaxProfit(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
