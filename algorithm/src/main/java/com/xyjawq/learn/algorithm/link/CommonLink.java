package com.xyjawq.learn.algorithm.link;

import lombok.Data;

/**
* @author: xyjawq
* @date: 2021/1/23
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
**/
public class CommonLink {

    @Data
    public static class Node {
       private Node next;
       private Integer value;
    }

    static void printCommon(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return;
        }
        if (head1.getValue() == head2.getValue()) {
            System.out.println((head1.getValue()));
            printCommon(head1.getNext(), head2.getNext());
        }else if (head1.getValue() > head2.getValue()) {
            printCommon(head1, head2.getNext());
        } else {
            printCommon(head1.getNext(), head2);
        }
    }

    static Node initLink(Integer[] values, int idx) {
        if (null == values || values.length == 0 || idx >= values.length) {
            return null;
        }
        Node node = new Node();
        node.setValue(values[idx]);
        node.setNext(initLink(values, idx+1));
        return node;
    }

    public static void main(String[] args) {
        Integer[] link1 = {1,2,3,4,6,7,20,23,23,54};
        Integer[] link2 = {3,4,5,6,7,8,23};
        printCommon(initLink(link1, 0), initLink(link2, 0));
    }

}
