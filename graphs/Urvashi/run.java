package Urvashi;
import java.io.*;
import java.security.KeyStore.Entry;
import java.util.*;
import static java.lang.System.out;
class Graph{

    Set<Node> nodes = new HashSet<>();

    public void addNode(Node node){

        nodes.add(node);
    }

}

class Node{

    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private int distance = Integer.MAX_VALUE-1;
    Map<Node, Integer> adjacentNodes = new HashMap<>();
    public Node(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void addNode(Node node, int edgeWeight){
        adjacentNodes.put(node, edgeWeight);
    }
    public Map<Node, Integer> getAdjNodes(){
        return adjacentNodes;
    }
    public int getDistance(){
        return distance;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public List<Node> getShortestPath(){
        return this.shortestPath;
    }
    public void setShortestPath(List<Node> shortestPath){
        this.shortestPath = shortestPath;
    }


}
public class run {
    
    public static void main(String args[]) throws IOException{
        ArrayList<Node> nodes = new ArrayList<>();
        Scanner s = new Scanner(new File("D:\\github uploads\\UIL-Repository\\graphs\\Urvashi\\urvashi.dat"));
        int testcases = Integer.parseInt(s.nextLine()); //get the total amount of test cases 
        while(s.hasNext()){ //Go thru the file 
          Character thing = s.next().charAt(0);//Get the first char of the first line 
          Integer lines = null;
         int holder = thing;
        
          if(thing > 48 && thing < 58){ //use ascii values to verify that it's an int 
            lines = Integer.parseInt(thing.toString()); //convert lines to the value
             //out.println(lines);
            int spellcount = Integer.parseInt(s.next());
            //out.println(spellcount);
            Node source = new Node(s.next());
            //out.println(source.getName());
            Node dest = new Node(s.next());
            nodes.add(source);
            nodes.add(dest);
          }
            
          if(lines != null){
            //building graph
            for(int i =0; i<lines; i++){
               Node node1 = new Node(s.next());
               //out.println(node1.getName());
               Node node2 = new Node(s.next());
               //out.println(node2.getName());
               node1.addNode(node2, Integer.parseInt(s.next()));  
               if(!nodes.contains(node1)){
                    nodes.add(node1);
                }
                if(!nodes.contains(node2)){
                    nodes.add(node2);
                }
                
                //add destinations according to file
            }
            
            Graph graph = new Graph();

            for(int i = 0; i < nodes.size(); i++){
                graph.addNode(nodes.get(i));
            }
            //graph built - should now run dijktra's algorithm

            graph = calcMinDistance(graph, nodes.get(0));
            out.printf("\n%s", nodes.get(1).getAdjNodes());
            out.printf("\n%s",nodes.get(1).getDistance());

          }
            
        }

    }


    public static Graph calcMinDistance(Graph graph, Node source){

        Set<Node> unsettledNodes = new HashSet<>();
        Set<Node> settledNodes = new HashSet<>();

        unsettledNodes.add(source);
        source.setDistance(0);

        while(unsettledNodes.size() != 0){
            
            Node currentNode = findLowestDistNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(java.util.Map.Entry<Node, Integer> adjPair : currentNode.getAdjNodes().entrySet()){
                
                Node adjNode = adjPair.getKey();
                Integer edgeWeight = adjPair.getValue();
                if(!settledNodes.contains(adjNode)){
                    calculateMiniumDistance(adjNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjNode);
                }
                
            }
            settledNodes.add(currentNode);
        }
        return graph;

    }

    public static Node findLowestDistNode(Set<Node> unsettledNodes){   
        Node lowestDistNode = null;
        int distance = Integer.MAX_VALUE;
        for(Node node : unsettledNodes){
            if (node.getDistance() < distance){
                distance = node.getDistance();
                lowestDistNode = node;   
            }
        }
        return lowestDistNode;
    }

    public static void calculateMiniumDistance(Node evalNode, Integer edgeWeight, Node sourceNode){
        Integer sourceDist = sourceNode.getDistance();
        if(sourceDist + edgeWeight < evalNode.getDistance()){
            evalNode.setDistance((sourceDist + edgeWeight));
            LinkedList<Node> shortestPath = new LinkedList<>();
            shortestPath.add(sourceNode);
            evalNode.setShortestPath(shortestPath);
        }
    }
}


