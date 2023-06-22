package DATA_STRUCTURE.Graph_Theory;
import java.util.*;

public class Graph_DFS_Stack {

    static ArrayList< ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

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
 
    static void DFS(int src,boolean [] vis){
        Stack<Integer> stack = new Stack<Integer>();
        vis[src] = true;
        stack.push(src);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            System.out.print(curr+" --> ");
            for(int n:graph.get(curr)){
                if(!vis[n]){
                    vis[n] = true;
                    stack.push(n);
                }
            }
        }        
    }
    static void DFS_Disconnected(boolean []vis){
        for (int i = 0; i < graph.size(); ++i){
            if (vis[i] == false)
                DFS(i, vis);
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int vertex = s.nextInt();

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

        boolean []vis = new boolean[graph.size()];
        DFS(source, vis);
        
        s.close();
    }
}
