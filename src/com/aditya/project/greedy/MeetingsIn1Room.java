package com.aditya.project.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        } else if (o1.pos < o2.pos) {
            return -1;
        }
        return 0;
    }
}

// TC : O(N)
// SC : O(N)
public class MeetingsIn1Room {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }
        Collections.sort(meetings, new MeetingComparator());
        int c = 1;
        int limit = meetings.get(0).end;
        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).start > limit) {
                c++;
                limit = meetings.get(i).end;
            }
        }
        System.out.println("No. of meetings : " + c);
    }
}
