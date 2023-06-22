package DATA_STRUCTURE.Graph_Theory;

import java.util.*;


public class Dijkstra {

    static int [][] graph;
    
    static int [] distance;

    static void addEdge(int u,int v,int w){
        graph[u][v] = w;
    }
    
    static int minimumDistance(boolean included[]){
        int min  = Integer.MAX_VALUE;
        int minINDEX = -1;
        for (int i = 0; i < graph.length; i++) {
            if(included[i] == false && distance[i]<=min){
                min = distance[i];
                minINDEX = i;
            }
        }
        return minINDEX;
    }


    static void fun_Dijkstra(int src){
        
        distance = new int[graph.length];
        
        boolean [] includedSPT = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            includedSPT[i] = false;
        }

        distance[src] = 0;

        for (int i = 0; i < graph.length; i++) {
 
            int u = minimumDistance(includedSPT);

            includedSPT[u] = true;

            for (int j = 0; j < graph.length; j++) {
                if(includedSPT[j] == false && 
                graph[u][j] != 0 && 
                distance[u] != Integer.MAX_VALUE &&
                (distance[u] + graph[u][j]) < distance[j] ){
                    distance[j] = distance[u] + graph[u][j];
                }
            }
        }

        printAnswer();

    }


    static void PrintAdjecencyMatrix(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void printAnswer(){
        System.out.println("vertex\t\tdistance form source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i+"\t\t"+distance[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();
        System.out.println("Enter the number of edges : ");
        int edge = s.nextInt();

        //Creating v * v size of graph
        graph = new int[vertex][vertex];

        for (int i = 0; i < edge; i++) {
            System.out.println("Enter source, destination and weight : ");
            int src = s.nextInt();
            int des = s.nextInt();
            int wgt = s.nextInt();
            
            addEdge(src, des, wgt);
        }
        PrintAdjecencyMatrix();
        fun_Dijkstra(0);
        s.close();
    }
}
