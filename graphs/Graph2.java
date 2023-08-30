import java.util.*;

public class Graph2 {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA){

        nodes.add(nodeA);

        
    }


    public Node getNode(String nodeName){
        Iterator<Node> it = nodes.iterator();

        while(it.hasNext()){
            if(it.next().getName().equals(nodeName))
            return it.next();
            
        }
        return null;
    }

    
    

}
