import java.util.*;
import java.util.Map.Entry;
import static java.lang.System.out;
//IMPLEMENTATION https://www.baeldung.com/java-dijkstra 

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
        graph = calculateShortestPathFromSource(graph, graph.getNode("A"));
        for(Node node : graph.getNodes()){

             out.printf("\n%s", node.getName());
             out.printf("\n%s", node.getDistance());
        }
       
}



    


    public static Graph2 calculateShortestPathFromSource(Graph2 graph, Node source){
            
            source.setDistance(0);
           
            Set<Node> settledNodes = new HashSet<>();
            Set<Node> unsettledNodes = new HashSet<>();


            unsettledNodes.add(source);

          //  out.printf("\n%s", source);
           // out.printf("\n%s", unsettledNodes);

            while(unsettledNodes.size() != 0 ){

                Node currentNode = getLowestDistanceNode(unsettledNodes);
                //out.printf("\n%s", currentNode);
                unsettledNodes.remove(currentNode); //remove the current Node b/c you're currently settling it 

                for(Entry< Node,Integer > adjacencyPair : currentNode.getAdjacentNodes().entrySet()){
                    //out.printf("\n%s", adjacencyPair);
                    Node adjacentNode = adjacencyPair.getKey();
                    Integer edgeWeight = adjacencyPair.getValue();

                    if(!settledNodes.contains(adjacentNode)){

                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode); //calculate the smallest distance from the source node to the next one
                        unsettledNodes.add(adjacentNode); //add the node to unsettled nodes 

                    }
                    
                }
                settledNodes.add(currentNode); //Find the minimum distance of the node, add it to the list
            }
            return graph;
            


    }

    public static Node getLowestDistanceNode(Set<Node> unsettledNodes){


        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        
        for(Node node: unsettledNodes){
            //out.printf("\n%s", node);
            int nodeDistance = node.getDistance();
          // out.printf("\n%s", node.getDistance());
            if(nodeDistance < lowestDistance){

                lowestDistance = nodeDistance; 
                lowestDistanceNode = node; 
            }

        }


        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){


        Integer sourceDistance = sourceNode.getDistance(); //get the distance of the currentNode 

        if(sourceDistance+edgeWeight < evaluationNode.getDistance()){ //add the distance plus the edge weight to get the next node's total distance

            evaluationNode.setDistance(sourceDistance + edgeWeight); 
            LinkedList<Node> shortestPath = new LinkedList<>((sourceNode.getShortestPath()));
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
