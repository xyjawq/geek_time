package com.xyjawq.learn.algorithm.link;

import com.xyjawq.learn.common.util.LinkUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.xyjawq.learn.common.util.LinkUtil.Node;

/**
* @author: xyjawq
* @date: 2021/2/13
* 反转单向和双向链表。分别实现反转单向链表和反转双向链表的函数。如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
**/
public class ReverseLink {

    public static Node reverseSingleLink(Node head) {
        if (null == head) {
            return null;
        }
        Node preNode = head;
        Node curNode = preNode.getNext();
        preNode.setNext(null);
        while (null != curNode) {
            Node next  = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    public static Node reverseDoubleLink(Node head) {
        if (null == head) {
            return null;
        }
        Node preNode = head;
        Node curNode = head.getNext();
        preNode.setNext(null);
        while (null != curNode) {
            Node next = curNode.getNext();
            curNode.setNext(curNode.getPre());
            curNode.setPre(next);
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        Node headS = LinkUtil.buildSingleLink(arr);
        Node headD = LinkUtil.buildDoubleLink(arr);
        LinkUtil.printLink(headS);
        System.out.println();
        LinkUtil.printLink(reverseSingleLink(headS));
        System.out.println("=========================");
        LinkUtil.printLink(headD);
        System.out.println();
        LinkUtil.printLink(reverseDoubleLink(headD));
    }
}
