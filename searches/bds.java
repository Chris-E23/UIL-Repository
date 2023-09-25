package searches;
import java.util.LinkedList;
import java.util.List;

public class bds {
    public static void main(String args[]){

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(2,3);

        g.BFS(2);

    }   



}
class Graph{



    private int V; 
    private List<Integer> adj[];

    Graph(int v){

        V = v;
        adj = new LinkedList[v];
        for(int i =0; i< v; ++i){
            adj[i] = new LinkedList();

        }
    }

    void addEdge(int v, int w){

        adj[v].add(w);
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        System.out.print(s + " ");
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            
            for(int i = 0; i < adj.length; i++){
                if(!visited[i]){

                    visited[i] = true;
                    queue.add(i);
                }
            }


        }
    }


}