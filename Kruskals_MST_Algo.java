package DATA_STRUCTURE.Graph_Theory;

import java.util.*;

public class Kruskals_MST {

    int v;
    int e;
    Edge edge[]; 

    Kruskals_MST(int v, int e) {
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    
    class Edge implements Comparable<Edge> {
        int src, des, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent;
        int rank;
    }

    int FIND(subset subs[], int i) {
        if (subs[i].parent != i) {
            subs[i].parent = FIND(subs, subs[i].parent);
            return subs[i].parent;
        } else {
            return subs[i].parent;
        }
    }

    void Union(subset sb[], int u, int v) {
        int x = FIND(sb, u);
        int y = FIND(sb, v);

        if (x == y) {
            return;
        }


        if (sb[x].rank < sb[y].rank) {
            sb[x].parent = y;
        } else if (sb[x].rank > sb[y].rank) {
            sb[y].parent = x;
        } else {
            sb[y].parent = x;
            sb[x].rank++;
        }
    }
    void kruskals(){
        Edge ans[] = new Edge[v];
         
        int e = 0;

        for (int i = 0; i < v; ++i) {
            ans[i] = new Edge();
        }

        Arrays.sort(edge);

        subset []subsets = new subset[v];

        for (int i = 0; i < ans.length; i++) {
            subsets[i] = new subset();
        }

        for (int i = 0; i < v; ++i) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i =0;
        while(e<v-1){
            Edge nextedge = edge[i++];
            int x = FIND(subsets, nextedge.src);
            int y = FIND(subsets, nextedge.des);
            if(x!=y){
                ans[e++] = nextedge;
                Union(subsets, x, y);
            }
        }

        System.out.println("After applying Kruskals Algorithm...");
        int minimumCost = 0;
        for (i = 0; i < e; ++i){
            System.out.println(ans[i].src + " -- " + ans[i].des+ " == " + ans[i].weight);
            minimumCost += ans[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "+ minimumCost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = s.nextInt();

        Kruskals_MST graph = new Kruskals_MST(v, e);
        for (int i = 0; i < e; i++) {
            System.out.println("Enter source for edge " + i + " : ");
            int sr = s.nextInt();
            System.out.println("Enter destination for edge " + i + " : ");
            int d = s.nextInt();
            System.out.println("Enter weight for edge (" + sr + "," + d + ") : ");
            int w = s.nextInt();
            
            graph.edge[i].src = sr;
            graph.edge[i].des = d;
            graph.edge[i].weight = w;
        }
        graph.kruskals();
        s.close();
    }
}
