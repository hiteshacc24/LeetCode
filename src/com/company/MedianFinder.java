package com.company;
import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        small.add(num);
        large.add(small.remove());
        if(small.size() < large.size()) {
            small.add(large.remove());
        }

    }

    public double findMedian() {
        return small.size() > large.size() ? (double)small.peek() : (small.peek() + large.peek()) * 0.5;
    }
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        m.addNum(5);
        System.out.print(m.findMedian());
    }
}
