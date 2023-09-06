import java.util.*;
import java.util.Map.Entry;
import static java.lang.System.out;
//IMPLEMENTATION https://www.baeldung.com/java-dijkstra 

/*NOTES:
 * I'm using out.printf cause we're learning that 
 * screw you if you don't like my comments
 */
public class run {
  

    public static void main(String args[]){

        String data = "A, B, C, D, E, F\nA, B, 10\nA, C, 1\nB, D, 12\nB, F, 15\nC, E, 10\nD, E, 2\nD, F, 1\nF, E, 5";
        Scanner scanner = new Scanner(data);
        String[] nodearr = scanner.nextLine().split(",\s");

        //out.println(Arrays.toString(nodearr));

        List<Node> nodes = new ArrayList<>();

        for(int i = 0; i < nodearr.length; i++){
            Node newNode = new Node(nodearr[i]);
            nodes.add(newNode);
        }
      

        List<String> nodeLines = new ArrayList<>();

        while(scanner.hasNext()){
            nodeLines.add(scanner.nextLine());
        }
        //out.println(nodeLines);


        for(int i = 0; i < nodeLines.size(); i++){
                String[] line = nodeLines.get(i).split(",\s");
                //out.printf("%s\n", Arrays.toString(line));
                for(int d = 0; d < nodes.size(); d++){
                    if(nodes.get(d).getName().equals(line[0])){
                        for(int k = 0; k < nodes.size(); k++){
                         if(nodes.get(k).getName().equals(line[1])){
                            nodes.get(d).addDestination(nodes.get(k), Integer.parseInt(line[2]));
                     }
                        
                    }
                       


                }
        }


        

    }

    /* 
        for(Node node : nodes){

            out.printf("\n%s", node.getAdjacentNodes());
        }
    */
        //out.printf("\n%s", nodes.get(1));


        Graph2 graph = new Graph2();

        for(int i = 0; i < nodes.size(); i++){
            graph.addNode(nodes.get(i));
        }
        //out.printf("\n%s", graph.getNode("A").getDistance());
        graph = calculateShortestPathFromSource(graph, nodes.get(0));
        out.printf("\n%s", graph.getNode("A").getDistance()); 

      //This current set up goes A->C->B->E->D->F with how the settled & unsettled nodes list goes
      //It's kinda wacky
      
      //SHOW THE DISTANCES!

      for(Node node : graph.getNodes()){

        out.printf("\nNode: %s, distance: %d", node.getName(), node.getDistance());

      }
}



    


    public static Graph2 calculateShortestPathFromSource(Graph2 graph, Node source){
            source.setDistance(0);

            Set<Node> settledNodes = new HashSet<>();
            Set<Node> unsettledNodes = new HashSet<>();


            unsettledNodes.add(source);

<<<<<<< HEAD
          //out.printf("\n%s", source);
           // out.printf("\n%s", unsettledNodes);

            while(unsettledNodes.size() != 0 ){
=======
            while(unsettledNodes.size() != 0){
>>>>>>> 20816d85f193e03884bb38bb99f130b5fc0c35c4

                Node currentNode = getLowestDistanceNode(unsettledNodes);
                //out.printf("\n VISTING NODE %s!", currentNode.getName());


                //choose to explore the adjacent node with the lowest distance from the current node
               unsettledNodes.remove(currentNode);
                /*This is a way to basically use a for-each loop for a map. Pretty useful to know */
                for(Entry< Node,Integer > adjacencyPair : currentNode.getAdjacentNodes().entrySet()){  

                    Node adjacentNode = adjacencyPair.getKey();
                    Integer edgeWeight = adjacencyPair.getValue();
                        /*If the settled nodes ArrayList doesn't contain the current adjacent node,
                        calculate the minimum distance from the 
                        */
                    if(!settledNodes.contains(adjacentNode)){
                        
                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                        unsettledNodes.add(adjacentNode);
                        /*Since we're not exploring the other nodes, simply calculate the distance
                        between the current node and its adjacentnodes
                        */

                    }
                    
                }
                settledNodes.add(currentNode);



            }
            return graph;
            


    }

    public static Node getLowestDistanceNode(Set<Node> unsettledNodes){


        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE; //Set the initial value of the lowest distance to be effectively infinity

        for(Node node: unsettledNodes){

            int nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance){ //Go through all the unsettled nodes
                                                //and find one with the lowest distance
                                                //from the current node
                lowestDistance = nodeDistance; 
                lowestDistanceNode = node; 
            }
        }


        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){


        Integer sourceDistance = sourceNode.getDistance();
        //Get the distance of the source node from the source source node lol
        

        /*if the current distance of the source node plus the edge weight is less than the current distance
        from the eval node's distance from the source source node then make its distance equal to the lesser 
        value. Hard to explain.
        */
        if(sourceDistance+edgeWeight < evaluationNode.getDistance()){ //If the distance from the

            evaluationNode.setDistance(sourceDistance + edgeWeight); 
            LinkedList<Node> shortestPath = new LinkedList<>((sourceNode.getShortestPath())); 
            /*Take this shortest path from the source node that you're on and make a new linked list
             and set the eval's node equal to that plus the sourceNode. 
             */
            shortestPath.add(sourceNode); 
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
