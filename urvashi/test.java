import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.util.*;

class test {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("urvashi\\urvashi_student.dat"));
        int C = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        for (int caseNum = 1; caseNum <= C; caseNum++) {
            int M = scanner.nextInt();
            int K = Integer.parseInt(scanner.next());
            String S = scanner.next();
            String T = scanner.next();
            scanner.nextLine(); // Consume the newline
            
            Map<String, ArrayList<Road>> graph = new HashMap<>();
            
            for (int i = 0; i < M; i++) {
                String U = scanner.next();
                String V = scanner.next();
                int W = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                
                // Create the graph by adding roads to the respective towns
                graph.computeIfAbsent(U, k -> new ArrayList<>()).add(new Road(V, W));
                graph.computeIfAbsent(V, k -> new ArrayList<>()).add(new Road(U, W));
            }
            
            int result = dijkstra(graph, S, T, K);
            // Print the result in the specified format
            System.out.println("Case #" + caseNum + ": " + (result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result));
             
            for(java.util.Map.Entry<String, ArrayList<test.Road>> adjacencyPair : graph.entrySet()){
                String firstTown = adjacencyPair.getKey();
                ArrayList<Road> allThatItLeadsTo = adjacencyPair.getValue();
                System.out.println(firstTown + " --> ");
                for(Road town : allThatItLeadsTo){

                    System.out.println(town.town + " toll: " + town.toll);
                   
                }


        }
        }
        
        scanner.close();

       
    }
    
    static class Road {
        String town;
        int toll;
        
        public Road(String town, int toll) {
            this.town = town;
            this.toll = toll;
        }
    }
    
    static int dijkstra(Map<String, ArrayList<Road>> graph, String start, String end, int maxSpells) {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        Set<String> visited = new HashSet<>();
        pq.offer(new State(start, 0, 0));
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            
            if (current.town.equals(end)) {
                return current.cost; //return this if it can return something
            }
            
            if (visited.contains(current.town)) {
                continue;
            }
            
            visited.add(current.town);
            
            for (Road road : graph.getOrDefault(current.town, new ArrayList<>())) {
                // Try not using the spell
                if (current.spellsUsed < maxSpells) {
                    pq.offer(new State(road.town, current.cost + road.toll, current.spellsUsed));
                }
                
                // Try using the spell
                int reversedToll = Integer.parseInt(new StringBuilder(Integer.toString(road.toll)).reverse().toString());
                pq.offer(new State(road.town, current.cost + reversedToll, current.spellsUsed + 1));
            }
        }
        
        return Integer.MAX_VALUE; // Return a large value if it's impossible to reach the destination
    }
    
    static class State {
        String town;
        int cost;
        int spellsUsed;
        
        public State(String town, int cost, int spellsUsed) {
            this.town = town;
            this.cost = cost;
            this.spellsUsed = spellsUsed;
        }
    }
}
