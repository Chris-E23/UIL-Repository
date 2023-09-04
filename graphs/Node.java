
import java.util.*;

public class Node {
    
private String name; 

private List<Node> shortestPath = new LinkedList<>();

private Integer distance = Integer.MAX_VALUE;


Map<Node, Integer> adjacentNodes = new HashMap<>();


public void addDestination(Node destination, int distance){
    adjacentNodes.put(destination, distance);

}

public Node(String name){

    this.name = name;
}


public void setDistance(int distance){

    this.distance = distance;

}

public Map<Node, Integer> getAdjacentNodes(){


    return adjacentNodes;
}


public Integer getDistance(){

    return this.distance; 
}

public List<Node> getShortestPath(){

    return this.shortestPath;

}

public void setShortestPath(List shortestPath2){

    this.shortestPath = shortestPath2; 
}


public String getName(){


    return this.name;
}
}

