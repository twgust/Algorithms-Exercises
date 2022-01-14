package OrdKedjor;

import java.util.ArrayList;

public class Node {
    private String node;
    private ArrayList<Node> edges = new ArrayList<>();
    private boolean visited = false;
    private int distance = 0;

    public Node(String name){
        this.node = name;
    }

    public void addEdge(Node n){
        edges.add(n);
    }

    public ArrayList<Node> getEdges(){
        return this.edges;
    }

    public String getName(){
        return this.node;
    }

    public void setName(String name){
        this.node = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
