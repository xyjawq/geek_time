package com.xyjawq.learn.algorithm.queue;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

/** 编写一个类，用两个栈实现队列，支持队列的基本操作
* @author xyjawq
* @date 2020/10/17
**/
public class QueueOf2Stack<T> {

    private Stack<T> in = new Stack<T>();
    private Stack<T> out = new Stack<T>();

    /**
     * 添加数据
     * @param data 数据
     */
    public void push(T data) {
        in.push(data);
    }

    /**
     * 将首个元素从队列中弹出
     * @return 如果队列是空的，就返回null
     */
    public T poll() {
        if (out.isEmpty()) {
            recombine(in, out);
        }
        return out.pop();
    }

    /**
     * 查看首个元素，不会移除首个元素
     * @return 如果队列是空的就返回null
     */
    public T peek() {
        if (out.isEmpty()) {
            recombine(in, out);
        }
        return out.peek();
   }

   public Boolean isEmpty() {
        return in.isEmpty()&&out.isEmpty();
   }

   private void recombine(Stack<T> source, Stack<T> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
   }

    public static void main(String[] args) {
        Integer[] elements = {1,2,9,5,4,0,3,5,6,7};
        QueueOf2Stack<Integer> queueOf2Stack = new QueueOf2Stack<Integer>();
        for (Integer element : elements) {
            queueOf2Stack.push(element);
            System.out.print(element + ",");
        }
        System.out.println();
        while (!queueOf2Stack.isEmpty()) {
            System.out.print(queueOf2Stack.poll() + ',');
        }
    }
}
