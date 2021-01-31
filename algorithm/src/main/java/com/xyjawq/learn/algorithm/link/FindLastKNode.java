package com.xyjawq.learn.algorithm.link;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author: xyjawq
* @date: 2021/1/31
 * 在单链表和双链表中删除倒数第K个节点，分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表中倒数第K个节点。
 * 如果链表长度为N，时间复杂度达到O(N),额外空间复杂度达到O(1)
**/
public class FindLastKNode {

    @Data
    @NoArgsConstructor
    public static class Node {
        private Node next;
        private Integer value;

        Node(Integer value) {
            this.value = value;
        }
    }

    @Data
    public static class DNode {
        private DNode pre;
        private DNode next;
        private Integer value;
    }

    public static Node findLastKNodeSingleLink(Node head, Integer k) {
        if (null == head || k <= 0) {
            return null;
        }
        Node curNode = head;
        while (null != curNode) {
            curNode = curNode.next;
            k--;
        }
        // 如果为正数说明k要比链表长度长，即不存在倒数k
        if (k > 0) {
            return null;
        }
        // 如果为0，即头节点就是要删除的节点
        if (k == 0) {
            Integer value = head.getValue();
            return head.next;
        }
        Node preNode = head;
        while (null != preNode && k+1 < 0) {
            preNode = preNode.next;
            k++;
        }
        Integer preValue = preNode.getValue();
        // 删除节点
        preNode.next = preNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        Node head = new Node(arr[0]);
        Node curNode = head;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new Node(arr[i]);
            curNode = curNode.next;
        }
        curNode = head;
        while (null != curNode) {
            System.out.print(curNode.getValue());
            curNode = curNode.next;
        }
        System.out.println();
        System.out.println("=====================");
        curNode = findLastKNodeSingleLink(head, 2);
        while (null != curNode) {
            System.out.print(curNode.getValue());
            curNode = curNode.next;
        }
        System.out.println();
    }

}
