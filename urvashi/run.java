import java.util.*;
import static java.lang.System.out;
import java.io.File;
import java.io.FileNotFoundException;


class Graph{
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node){
        nodes.add(node);
    }
   
    public Set<Node> getNodes(){
        return nodes;
    }
}

class Node{ //Node Implementation
    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = 0;

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
    public  Map<Node, Integer> getAdjacentNodes(){
        return adjacentNodes;
    }
    public Integer getDistance(){
        return distance;
    }
    public List<Node> getShortestPath(){
        return this.shortestPath;
    }
    public void setShortestPath(List shortestPath){
        this.shortestPath = shortestPath;
    }
    public String getName(){
        return this.name;
    }

}
public class run {
    
    public static void main(String[] args) throws FileNotFoundException{

        Scanner s = new Scanner(new File("urvashi_student.dat"));
        int testcases = s.nextInt();
        
        List<List<String>> lines = new ArrayList<>();
        while(s.hasNextLine()){
           String line = s.nextLine();
           String[] elements = line.split("\s");
           out.print("\n" + elements[0]);
           //int runs = Integer.parseInt(elements[0]);
            //List<String> lineArr = new ArrayList<>();
            //for(int i =0; i < runs; i++){
             //   lineArr.add(s.nextLine());
           // }
        }
        out.printf("\n%s", lines);
     
        

    }

}

