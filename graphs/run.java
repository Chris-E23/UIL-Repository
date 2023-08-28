import java.util.*;
import java.util.Map.Entry;

//IMPLEMENTATION https://www.baeldung.com/java-dijkstra 

public class run {
    




    public static void main(String args[]){


        /* 
        unweightedUndirectedGraph graph = new unweightedUndirectedGraph(4);
        weightedUndirectedGraph graph2 = new weightedUndirectedGraph(4);
        unweightedDirectedGraph graph3 = new unweightedDirectedGraph(4);
        weightedDirectedGraph graph4 = new weightedDirectedGraph(4);
      

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        System.out.printf("%s", graph);
        System.out.printf("\n");
        graph2.addEdge(0,1, 4);
        graph2.addEdge(0,3, 6);
        System.out.printf("%s", graph2);
        System.out.printf("\n");
        graph3.addEdge(0,1);
        graph3.addEdge(0,3);
        System.out.printf("%s", graph3);
        System.out.printf("\n");
        graph4.addEdge(0,1, 4);
        graph4.addEdge(0,3, 6);
        System.out.printf("%s", graph4);

    */

        String data = "A, B, C, D \n A, B, 10 \n A, C, 15 \n C, E, 10 \n D, E, 2\n D, F, 1 \n F, E, 5";
        Scanner scanner = new Scanner(data);

        List<String> nodes;

        String[] nodearr = scanner.nextLine().split(",");



        System.out.println(Arrays.toString(nodearr));



    }

    public List<Node> buildGraph(List<String> nodeList){
        return null; //placeholder



    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source){
            source.setDistance(0);

            Set<Node> settledNodes = new HashSet<>();
            Set<Node> unsettledNodes = new HashSet<>();


            unsettledNodes.add(source);

            while(unsettledNodes.size() != 0 ){

                Node currentNode = getLowestDistanceNode(unsettledNodes);
                unsettledNodes.remove(currentNode);

                for(Entry< Node,Integer > adjacencyPair : currentNode.getAdjacentNodes().entrySet()){
                    Node adjacentNode = adjacencyPair.getKey();
                    Integer edgeWeight = adjacencyPair.getValue();

                    if(!settledNodes.contains(adjacentNode)){

                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                        unsettledNodes.add(adjacentNode);

                    }
                    settledNodes.add(adjacentNode);
                }
                



            }
            return graph;
            


    }

    public static Node getLowestDistanceNode(Set<Node> unsettledNodes){


        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for(Node node: unsettledNodes){

            int nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance){

                lowestDistance = nodeDistance; 
                lowestDistanceNode = node; 
            }
        }


        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){


        Integer sourceDistance = sourceNode.getDistance();

        if(sourceDistance+ edgeWeight < evaluationNode.getDistance()){

            evaluationNode.setDistance(sourceDistance + edgeWeight); 
            LinkedList<Node> shortestPath = new LinkedList<>((sourceNode.getShortestPath()));
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
