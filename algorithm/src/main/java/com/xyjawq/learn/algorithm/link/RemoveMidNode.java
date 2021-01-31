package com.xyjawq.learn.algorithm.link;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author: xyjawq
* @date: 2021/1/31
 * 删除链表的中间和a/b处的节点
**/
public class RemoveMidNode {

    @Data
    @NoArgsConstructor
    public static class Node {
        private Node next;
        private Integer value;

        Node(Integer value) {
            this.value = value;
        }
    }

    // 通过步长的方式求解，也可以使用FindLaskKNode的思路
    public static Node removeMidNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        Node curNode = head;
        Node nextNode = head.getNext().getNext();
        while (null != curNode && null != nextNode) {
            curNode = curNode.getNext();
            // 步长为二
            nextNode = nextNode.getNext().getNext();
        }
        curNode.next = curNode.next.next;
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
        curNode = removeMidNode(head);
        while (null != curNode) {
            System.out.print(curNode.getValue());
            curNode = curNode.next;
        }
    }
}
