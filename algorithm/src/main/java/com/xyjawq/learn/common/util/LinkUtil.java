package com.xyjawq.learn.common.util;

import lombok.Data;
import lombok.NoArgsConstructor;

public class LinkUtil {
    @Data
    @NoArgsConstructor
    public static class Node {
        private Node next;
        private Node pre;
        private Integer value;

        Node(Integer value) {
            this.value = value;
        }

        public String toString() {
            return null == this.value ? "" : this.value.toString();
        }
    }

    public static Node buildSingleLink(Integer[] arr) {
        if (null == arr || 0 == arr.length) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node preNode = head;
        for (int i = 1; i < arr.length; ++i) {
            Node curNode = new Node(arr[i]);
            preNode.next = curNode;
            preNode = curNode;
        }
        return head;
    }

    public static Node buildDoubleLink(Integer[] arr) {
        if (null == arr || 0 == arr.length) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node preNode = head;
        for (int i = 1; i < arr.length; ++i) {
            Node curNode = new Node(arr[i]);
            preNode.next = curNode;
            curNode.pre = preNode;
            preNode = curNode;
        }
        return head;
    }

    public static void printLink(Node head) {
        Node curNode = head;
        while (null != curNode) {
            System.out.print(curNode.getValue());
            System.out.print(",");
            curNode = curNode.getNext();
        }
    }

}
