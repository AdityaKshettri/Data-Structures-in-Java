package com.aditya.project.greedy;

import java.util.Arrays;

class Job {

    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };
        int n = jobs.length;
        Arrays.sort(jobs, (x, y) -> y.profit - x.profit);
        int max = 0;
        for (Job job : jobs) {
            if (job.deadline > max) {
                max = job.deadline;
            }
        }
        int[] res = new int[max + 1];
        Arrays.fill(res, -1);
        int c = 0;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (res[j] == -1) {
                    res[j] = i;
                    c++;
                    profit += jobs[i].profit;
                    break;
                }
            }
        }
        System.out.println("No. of jobs done : " + c);
        System.out.println("Max profit : " + profit);
    }
}
