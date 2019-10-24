package com.company;
import java.util.*;
public class JobOrder {
    public static List<Integer> topSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobgraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobgraph);
    }
    public static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> order = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while(nodes.size() > 0) {
            JobNode node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            boolean containsCycle = dfsTraverse(node, order);
            if(containsCycle) return new ArrayList<>();
        }
        return order;
    }
    public static boolean dfsTraverse(JobNode node, List<Integer> order) {
        if(node.visited) return false;
        if(node.visiting) return true;
        node.visiting = true;
        for(JobNode prereq : node.prereqs) {
            boolean containsCycle = dfsTraverse(prereq, order);
            if(containsCycle) return true;
        }
        node.visited = true;
        node.visiting = false;
        order.add(node.job);
        return false;
    }
    public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for(Integer[] dep : deps) {
            graph.addPrereq(dep[1], dep[0]);
        }
        return graph;
    }
    static class JobGraph {
        List<JobNode> nodes;
        HashMap<Integer, JobNode> graph;
        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<>();
            graph = new HashMap<>();
            for(Integer job : jobs) {
                addNode(job);
            }
        }
        public void addNode(int job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }
        public void addPrereq(int job, int prereq) {
            JobNode jobNode = getNode(job);
            JobNode prereqNode = getNode(prereq);
            jobNode.prereqs.add(prereqNode);
        }
        public JobNode getNode(int job) {
            if(!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }
    }
    static class JobNode {
        int job;
        List<JobNode> prereqs;
        boolean visited;
        boolean visiting;
        public JobNode(int job) {
            this.job = job;
            prereqs = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1,2});
        deps.add(new Integer[]{1,3});
        deps.add(new Integer[]{3,2});
        deps.add(new Integer[]{4,2});
        deps.add(new Integer[]{4,3});
        List<Integer> result = topSort(jobs, deps);
        System.out.print(result);
    }
}
