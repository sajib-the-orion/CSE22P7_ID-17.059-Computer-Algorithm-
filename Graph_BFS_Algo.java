package ComputerAlgorithm.Graph_Theory;

import java.util.*;

public class Graph_BFS {
   

    static void AddEdge(ArrayList<ArrayList<Integer>> ll,int u,int v){
        ll.get(u).add(v);
        ll.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> gr){

        for (int i = 0; i < gr.size(); i++) {
            System.out.print("\nAdjacency list for "+i+" ");
 
            for (int j = 0;j < gr.get(i).size() ; j++) {
                System.out.print("--> "+gr.get(i).get(j));
            }
            System.out.println();
            
        }
    }

    static void BFS(ArrayList<ArrayList<Integer>> graph,int source){
        boolean [] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int curr = q.poll(); 
            System.out.print(curr+" Visited ! \n");           
            for (int n : graph.get(curr)) {
                if(!visited[n]){
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        ArrayList< ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }

        System.out.println("Enter number of edges : ");
        int e = s.nextInt();


        for (int i = 0; i < e; i++) {
            System.out.println("Enter source and destination : ");
            int u = s.nextInt();
            int v = s.nextInt();
            AddEdge(graph, u, v);
        }

        printGraph(graph);

        System.out.println("Enter source for traversal : ");
        int source = s.nextInt();

        BFS(graph, source);

        s.close();
    }
}
