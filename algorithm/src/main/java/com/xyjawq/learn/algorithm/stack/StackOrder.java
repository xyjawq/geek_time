package com.xyjawq.learn.algorithm.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
 * 如何完成排序？
 * @author: xyjawq
 * @date: 2020/11/8
**/
public class StackOrder {

    public static boolean sortStackByStack(Stack<Integer> targetStack) {

        /** 辅助栈 */
        Stack<Integer> helpStack = new Stack<Integer>();

        while (!targetStack.isEmpty()) {
            Integer targetTop = targetStack.pop();
            if (helpStack.isEmpty()) {
                helpStack.push(targetTop);
            } else {
                // 查找当前栈顶所能入栈的位置
                while (!helpStack.isEmpty()) {
                    Integer helpTop = helpStack.pop();
                    if (targetTop <= helpTop) {
                        helpStack.push(helpTop);
                        break;
                    }
                    targetStack.push(helpTop);
                }
                helpStack.push(targetTop);
            }
        }
        System.out.println(helpStack);
        moveToOther(targetStack, helpStack);
        return true;
    }

    private static boolean moveToOther(Stack<Integer> target, Stack<Integer> source) {
        if (null == source) {
            return false;
        }

        if (null == target) {
            target = new Stack<Integer>();
        }
        while (!source.isEmpty()) {
            Integer value = source.pop();
            target.push(value);
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Integer[] values = {3,1,4,7,9,2,3,4,6};
        for (Integer value : values) {
            stack.push(value);
        }

        System.out.println(stack);
        StackOrder.sortStackByStack(stack);
        System.out.println(stack);

    }
}
