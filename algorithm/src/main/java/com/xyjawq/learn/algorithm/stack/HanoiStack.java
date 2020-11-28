package com.xyjawq.learn.algorithm.stack;

import java.awt.image.SampleModel;
import java.util.Iterator;
import java.util.Stack;

/**
 * 5.用栈求解汉诺塔问题，限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有N层时，打印最优移动
 * 过程和最优移动总步数。要求：
 * * 方法一：递归的方法
 * * 方法二：非递归的方法，用栈来模拟汉诺塔的三个塔
 * @author: xyjawq
 * @date: 2020/11/15
**/
public class HanoiStack {

    public static int hanoi(Stack<Integer> left, Stack<Integer> mid, Stack<Integer> right, Integer size, boolean isLeft) {
        if (0 == size) {
            return 0;
        }
        int count = 0;
        count += hanoi(left, mid, right, size - 1, isLeft);
        Integer leftBottom = left.pop();
        mid.push(leftBottom);
//        System.out.println("move " + leftBottom + " from " + (isLeft ? "left" : "right") + " to mid");
        count++;
        count += hanoi(right, mid, left, size - 1, !isLeft);
        Integer midBottom = mid.pop();
        right.push(midBottom);
//        System.out.println("move " + midBottom + " form mid to " + (isLeft ? "right" : "left"));
        count++;
        count += hanoi(left, mid, right, size - 1, isLeft);
        return count;
    }

    public static void testCase(Stack<Integer> data) {
        Stack<Integer> left = data;
        Stack<Integer> mid = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        System.out.println("阶数: " + data.size() + ", 步数: " + hanoi(left, mid, right, left.size(), true));
    }
    public static void main(String[] args) {
        Stack<Integer> left = new Stack<Integer>();
        int length = 10;
        while (length-->0) {
            left.push(length);
            Stack<Integer> copy = new Stack<Integer>();
            Iterator<Integer> iterator = left.iterator();
            while (iterator.hasNext()) {
                copy.push(iterator.next());
            }
            testCase(copy);
        }
    }
}
