package com.xyjawq.learn.algorithm.stack;

import java.util.Stack;

/** 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别是5、4、3、2、1，将这个栈转置后，
 * 从栈顶到栈底为1、2、3、4、5,也就是实现栈中元素的逆序,但是只能用递归函数来实现，不能用其他数据结构。
 * @author: xyjawq
 * @date: 2020/10/25
**/
public class ReverseStack {

    private Stack<Integer> data;

    public static Integer getAndRemoveLastElement(Stack<Integer> data) {
        Integer result = data.pop();
        if (data.isEmpty()) {
            return result;
        } else {
            Integer last = getAndRemoveLastElement(data);
            data.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> data) {
        if (data.isEmpty()) {
            return;
        }
        Integer ele = getAndRemoveLastElement(data);
        reverse(data);
        data.push(ele);
    }

    public static void main(String[] args) {
        Stack<Integer> data = new Stack<Integer>();
        Integer[] source = {1,2,3,4,5};
        System.out.println(source);
        for (Integer ele : source) {
            data.push(ele);
        }
        System.out.println(data);
        ReverseStack.reverse(data);
        System.out.println(data);
    }
}
