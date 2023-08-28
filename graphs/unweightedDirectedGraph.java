
class unweightedDirectedGraph{


    int adjMatrix[][];
    int vertices;

    public unweightedDirectedGraph(int vertices){

        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];



    }

    public void addEdge(int i, int j){

        adjMatrix[i][j] = 1;
      

    }

    public void removeEdge(int i, int j){
        adjMatrix[i][j] = 0;
      
        
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < vertices; i++ ){
            sb.append("\n");
            for(int j : adjMatrix[i]){
                
                String num = j==1 ? "1" : "0"; 
                sb.append(num + " ");
               
                
            }
           
        }
         return sb.toString();


    }




}