package com.arithmetic;

/**
 * 冒泡算法
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] datas = {8,7,6,5,4,9,11,22,13};
        //排序前
        System.out.println("排序前");
        output(datas);
        //排序
        sort(datas);
        //排序后
        System.out.println("排序后");
        output(datas);
    }
    //冒泡排序
    public static void sort(int[] datas) {
        int count = 0;
        //数组的长度
        int num = datas.length;
        // for (int i = 0; i < num-1; i++) {//外循环控制比较轮数
        //     for (int j = i+1; j < num-i-1; j++) {
        //         count++;
        //         if(datas[i]>datas[j]) {
        //             int temp = datas[j];
        //             datas[j] = datas[i];
        //             datas[i] = temp;
        //         }
        //     }
        //
        // }
        for (int i = 0; i < num-1; i++) {//外循环控制比较轮数
            for (int j = 0; j < num-i-1; j++) {
                count++;
                if(datas[j]>datas[j+1]) {
                    int temp = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = temp;
                }
            }

        }
        System.out.println(count);
    }
    //输出数组的元素
    public static void output(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i]+" ");
        }
        System.out.println();
    }
}
