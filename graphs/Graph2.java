import java.util.*;

public class Graph2 {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA){

        nodes.add(nodeA);

        
    }


    public Set<Node> getNodes(){

        return nodes;
    }

    public Node getNode(String nodeName){
        Iterator<Node> it = nodes.iterator();

        while(it.hasNext()){
            Node curr = it.next();
            if(curr.getName().equals(nodeName)){

                return curr;
            }
            
            
        }
        return null;
    }

    
    

}
