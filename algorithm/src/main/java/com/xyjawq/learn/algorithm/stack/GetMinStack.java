package com.xyjawq.learn.algorithm.stack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* @author: xyjawq
* @date: 2020/9/19
 * 实现一个特殊的栈，在实现栈的基础功能的基础上，再实现返回栈中最小元素的操作
 * 1.pop、push、getMin操作的实践复杂度都是O(1)
 * 2.实现的栈类型可以使用线程的栈结构
**/
@Data
public class GetMinStack<T extends Comparable> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> min;

    @Getter
    @Setter
    class Node<T> {
        private Node pre;
        private Node next;
        private T value;

        Node(T value){
            this.value = value;
        }
    }

    public void push(T value) {
        if (null == value) {
            return;
        }
        Node newNode = new Node(value);

        // 尾初始化
        if (null == tail) {
            newNode.setPre(newNode);
            this.setTail(newNode);
        } else {
            this.tail.setNext(newNode);
            newNode.setPre(this.tail);
            this.setTail(newNode);
        }
        // 头初始化
        if (null == head) {
            this.setHead(this.getTail());
            this.getHead().setNext(this.getTail());
        }

        // 存储最小值
        if (null == this.getMin()) {
            this.setMin(newNode);
        } else if(min.getValue().compareTo(newNode.getValue()) > 0 ) {
            this.setMin(newNode);
        }
    }

    public T pop() {
        if (null == tail) {
            return null;
        }
        T res = tail.getValue();
        Node pre = tail.getPre();
        pre.setNext(null);
        setTail(pre);
        return res;
    }

    public T getMin() {
        if (null == this.min) {
            return null;
        }
       return this.min.getValue();
    }

    /**
     * 方案问题：用单值存储最小值，虽然在入栈的时候可以通过单次比较来实现O(1)，单在出栈时无法在O(1)复杂度找到最小值
     */
    /***************答案实现**************/
    /***
     * 通过两个栈，一个正常的栈，另一个栈存储每次压入时的最小值
     *
     */

    public static void main(String[] args) {

        GetMinStack<Long> minStack = new GetMinStack<Long>();
        minStack.push(10L);
        minStack.push(100L);
        minStack.push(20L);
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }
}
