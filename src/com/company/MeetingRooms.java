package com.company;

import java.util.*;

public class MeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue<>();
        allocator.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static void main(String[] args) {
        int[][] meetings = {
                {1, 10},
                {2, 7},
                {3, 19},
                {21,56},
                {8, 12},
                {10, 20},
                {11, 30}
        };
        int result = minMeetingRooms(meetings);
    }

    ;
}