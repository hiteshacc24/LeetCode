package com.company;

import java.util.*;
public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       for(ListNode head : lists) {
           while(head != null) {
               minHeap.offer(head.val);
               head = head.next;
           }
       }
       ListNode dummy = new ListNode(-1);
       ListNode head = dummy;
       while(!minHeap.isEmpty()) {
           head .next= new ListNode(minHeap.remove());
           head = head.next;
       }
       return dummy.next;
    }
}
