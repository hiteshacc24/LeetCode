package com.company;

class GraphUnionFind {
    int E, V;
    Edge[] edge;

    class Edge {
        int src, dest;
    }

    GraphUnionFind(int nV, int nE) {
        V = nV;
        E = nE;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }

    }

    class subset {
        int parent;
        int rank;
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[yroot].rank < subsets[xroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }


    int isCycle(GraphUnionFind graph) {
        int V = graph.V;
        int E = graph.E;
        subset[] subsets = new subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (int i = 0; i < E; i++) {
            int x = find(subsets, graph.edge[i].src);
            int y = find(subsets, graph.edge[i].dest);
            if (x == y) {
                return 1;
            }
            union(subsets, x, y);
        }
        return 0;


    }

    public static void main(String[] args) {
/* Let us create the following graph
    0
    | \
    | \
    1-----2 */

        int V = 3, E = 3;
        GraphUnionFind graph = new GraphUnionFind(V, E);

// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

// add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

// add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
