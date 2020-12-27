package com.xyjawq.learn.algorithm.stack;

import java.util.*;

/**
 * @author: xyjawq
 * @date: 2020/12/27
 *
 *
 * 定义二叉树节点如下:
 * public class Node {
 *     public int value;
 *     public Node left;
 *     public Node right;
 *
 *     public Node(int data) {
 *         this.value = data;
 *     }
 * }
 * 一个数组的MaxTree定义如下。
 * * 数组必须没有重复元素
 * * MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
 * * 包括MaxTree数在内且在其中的每一个子数上，值最大的节点都是树的头。
 * 给定一个没有重复元素的数组arr,写出生成这个数组的MaxTree的函数，要求如果数组长度N，则时间复杂度为O(N)、额外空间复杂度为O(N)。
 */
public class ArrayMaxTree {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
           this.value = data;
        }
    }

    public Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        HashMap<Node, Node> lBig = new HashMap();
        HashMap<Node, Node> rBig = new HashMap();
        Stack<Node> stack = new Stack<Node>();
        // 寻找每个元素左边最近一个比自己大的数
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBig);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBig);
        }
        // 寻找每个元素右边最近一个比自己大的数
        for (int i = nArr.length - 1; i >= 0; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value > curNode.value) {
                popStackSetMap(stack, rBig);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBig);
        }

        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBig.get(curNode);
            Node right = rBig.get(curNode);
            if (null == left && null == right) {
                head = curNode;
            } else if (null == left) {
                if (null == right.left) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (null == right) {
                if (null == left.left) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (null == parent.left) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }
    private void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node node = stack.pop();
        if (stack.isEmpty()) {
            map.put(node, null);
        } else {
            map.put(node, stack.peek());
        }
    }

}
