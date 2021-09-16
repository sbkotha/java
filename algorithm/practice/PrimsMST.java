package algorithm.practice;

import java.util.*;

public class PrimsMST {
    static LinkedList<GraphEdge>[] graph = new LinkedList[9];
    static Collection<GraphEdge> mstEdges = new ArrayList<>();
    static Collection<Integer> mstNodes = new ArrayList<>();

    public static void main(String[] args) {
        initGraph();
        formGraph();
        findMST();
        printMST();
    }

    private static void printMST() {
        for (GraphEdge edge : mstEdges) {
            System.out.println(edge.fromNode + " --> " + edge.toNode + " : " + edge.edgeWeight);
        }
    }

    private static void findMST() {
        // Take a random node and take its min edge
        PriorityQueue<GraphEdge> minEdges = new PriorityQueue<>();
        for (Iterator<GraphEdge> it = graph[6].iterator(); it.hasNext(); ) {
            minEdges.add(it.next());
        }

        boolean solutionFound = false;

        while (!minEdges.isEmpty() && !solutionFound) {
            GraphEdge edge = minEdges.poll();
            if (canInclude(edge)) {
                addSolutionEdge(edge.fromNode, edge.toNode, edge.edgeWeight);
                // Add all the edges of toNode to the min list
                Iterator<GraphEdge> it = graph[edge.toNode].iterator();
                while (it.hasNext()) {
                    minEdges.add(it.next());
                }
            }
            //Check if the MST is formed
            solutionFound = isMSTFormed();
        }
    }

    private static boolean isMSTFormed() {
        return mstEdges.size() == 9;
    }

    private static boolean canInclude(GraphEdge edge) {
       if (mstNodes.contains(edge.fromNode) && mstNodes.contains(edge.toNode)) {
           return false;
       }
       return true;
    }

    private static void formGraph() {
        addEdge(0,1,4);
        addEdge(0,7,8);
        addEdge(1,0,4);
        addEdge(1,7,11);
        addEdge(1,2,8);
        addEdge(2,1,8);
        addEdge(2,8,2);
        addEdge(2,5,4);
        addEdge(2,3,7);
        addEdge(3,2,7);
        addEdge(3,5,14);
        addEdge(3,4,9);
        addEdge(4,3,9);
        addEdge(4,5,10);
        addEdge(5,4,10);
        addEdge(5,3,14);
        addEdge(5,2,4);
        addEdge(5,6,2);
        addEdge(6,5,2);
        addEdge(6,8,6);
        addEdge(6,7,1);
        addEdge(7,6,1);
        addEdge(7,8,7);
        addEdge(7,1,11);
        addEdge(7,0,8);
        addEdge(8,7,7);
        addEdge(8,2,2);
        addEdge(8,6,6);
    }

    private static void initGraph() {
        for (int i=0; i < 9; i++) {
            graph[i] = new LinkedList<GraphEdge>();
        }
    }

    public static void addEdge(int fromVertex, int toVertex, int weight) {
        graph[fromVertex].add(new GraphEdge(fromVertex, toVertex, weight));
    }

    public static void addSolutionEdge(int fromVertex, int toVertex, int weight) {
        mstEdges.add(new GraphEdge(fromVertex, toVertex, weight));
        if (!mstNodes.contains(fromVertex)) {
            mstNodes.add(fromVertex);
        }
        if (!mstNodes.contains(toVertex)) {
            mstNodes.add(toVertex);
        }
    }
}

class GraphEdge implements Comparable<GraphEdge> {
    int fromNode;
    int toNode;
    int edgeWeight;

    GraphEdge(int from, int to, int weight) {
        this.fromNode = from;
        this.toNode = to;
        this.edgeWeight = weight;
    }

    @Override
    public int compareTo(GraphEdge o) {
        return this.edgeWeight - o.edgeWeight;
    }
}
