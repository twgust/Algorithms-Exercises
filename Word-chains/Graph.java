package OrdKedjor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Graph {

    private final ArrayList<Node> vertices;

    public Graph(ArrayList<Node> words){
        this.vertices = words;
        calcEdges(vertices);
    }

    public void calcEdges(ArrayList<Node> nodes){
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                if(!nodes.get(i).getName().equals(nodes.get(j).getName())){
                    Node otherN = nodes.get(j);
                    if(controlWord(n, otherN)){
                        n.addEdge(otherN);
                    }
                }
            }
        }
    }


    public boolean controlWord(Node current, Node comparedTo){
        String word = current.getName();
        String compareWord = comparedTo.getName();
        int counter = 0;
        char[] compared = compareWord.toCharArray();

        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (int j = 0; j < compareWord.length(); j++) {
                if(ch == compareWord.charAt(j) && compared[j] != 0){
                    compared[j] = 0;
                    counter++;
                    break;
                }
            }

        }
        if(counter == 4){
            return true;
        }
        else return false;
    }

    public int BFS(Node start, Node goal){

        for (int i = 0; i < vertices.size(); i++) {
            Node n = vertices.get(i);
            n.setDistance(0);
            n.setVisited(false);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Node n = queue.remove();
            if(n.getName().equals(goal.getName())){
                return n.getDistance();
            }
            for (int i = 0; i < n.getEdges().size(); i++) {
                Node e = n.getEdges().get(i);
                if(!e.isVisited()){
                    e.setDistance(n.getDistance()+1);
                    e.setVisited(true);
                    queue.add(e);
                }
            }
        }
        return -1;
    }





    public static void main(String[] args) throws IOException {
        String fnam = "text/250-data.txt";
        BufferedReader r =
                new BufferedReader(new InputStreamReader(new FileInputStream(fnam)));
        ArrayList<Node> words = new ArrayList<Node>();
        while (true) {
            String word = r.readLine();
            if (word == null) { break; }
            assert word.length() == 5;  // indatakoll, om man kör med assertions på
            words.add(new Node(word));
        }

        Graph graph = new Graph(words);

        fnam = "testfall/testfall-250.txt";
        BufferedReader rr =
                new BufferedReader(new InputStreamReader(new FileInputStream(fnam)));
        while (true) {
            String line = rr.readLine();
            if (line == null) { break; }
            assert line.length() == 11; // indatakoll, om man kör med assertions på
            String start = line.substring(0, 5);
            String goal = line.substring(6, 11);
            // ... sök väg från start till goal här
           // System.out.println(start + " " + goal);
            Node startN = null;
            Node goalN = null;
            for (int i = 0; i < words.size(); i++) {
                if(start.equalsIgnoreCase(words.get(i).getName())){
                    startN = words.get(i);
                }
                if(goal.equalsIgnoreCase(words.get(i).getName())){
                    goalN = words.get(i);
                }
            }
            //Detta bör inte ske men har lagt till det just in case
            if(startN == null || goalN == null){
                System.out.println("Word not found");
                System.exit(-1);
            }
            System.out.println(graph.BFS(startN,goalN));
        }





    }





}

