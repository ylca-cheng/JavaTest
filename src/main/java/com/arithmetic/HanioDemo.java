package com.arithmetic;

/**
 * 汉诺塔问题
 * 测试递归算法
 * Created by niecheng on 2019/5/30.
 */
public class HanioDemo {
    public static int i = 0;

    /**
     * 移动盘子
     *
     * @param n
     * @param from
     * @param to
     */
    public void move(int n, char from, char to) {
        i++;
        System.out.printf("第%d步：将%d号盘子%c-------------->%c\n", i, n, from, to);
    }


    /**
     * 汉诺塔递归函数
     * n表示要将多少个"圆盘"从起始柱子移动至目标柱子
     * start_pos表示起始柱子,tran_pos表示过渡柱子,end_pos表示目标柱子
     *
     * @param n 盘子数量
     * @param start_pos 起始柱子
     * @param tran_pos 中转柱子
     * @param end_pos 目标柱子
     */
    public void hanio(int n, char start_pos, char tran_pos, char end_pos) {
        //很明显,当n==1的时候,我们只需要直接将圆盘从起始柱子移至目标柱子即可.
        if (n == 1) {
            move(n, start_pos, end_pos);
        } else {
            // 递归处理,一开始的时候,先将n-1个盘子移至过渡柱上
            hanio(n - 1, start_pos, end_pos, tran_pos);
            // 然后再将底下的大盘子直接移至目标柱子即可
            move(n, start_pos, end_pos);
            // 然后重复以上步骤,递归处理放在过渡柱上的n-1个盘子
            // 此时借助原来的起始柱作为过渡柱(因为起始柱已经空了)
            hanio(n - 1, tran_pos, start_pos, end_pos);
        }
    }

    public static void main(String[] args) {
        HanioDemo demo = new HanioDemo();
        demo.hanio(4, 'A','B','C');
    }
}
