package algorithm;

import java.util.*;

public class Graph {
    int graphSize = 0;
    LinkedList<Integer> edges[];
    public Graph(int size) {
        this.graphSize = size;
        this.edges = new LinkedList[size];
        for (int i=0; i < size; i++) {
            this.edges[i] = new LinkedList<Integer>();
        }
    }

    public void addEdges(int fromVertex, int toVertex) {
        this.edges[fromVertex].add(toVertex);
    }

    public void recursiveDFSTraverse(int startVertex) {
        boolean traversed[] = new boolean[this.graphSize];
        this.BFSTravese(startVertex, traversed);
        System.out.println();
    }

    public void BFSTravese(int startVertex, boolean traversed[]) {
        traversed[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int i=0; i < this.edges[startVertex].size(); i++) {
            if (!traversed[this.edges[startVertex].get(i)]) {
                BFSTravese(this.edges[startVertex].get(i), traversed);
            }
        }
    }

    public static void main(String[] args) {
        /*
        Graph t = new Graph(6);
        t.addEdges(0,1);
        t.addEdges(0,2);
        t.addEdges(1,0);
        t.addEdges(1,3);
        t.addEdges(2,0);
        t.addEdges(2,3);
        t.addEdges(3,1);
        t.addEdges(3,2);
        t.addEdges(3,4);
        t.addEdges(3,5);
        t.addEdges(4,3);
        t.addEdges(5,3);
        t.iterativeDFSTraverse(0);
        t.recursiveDFSTraverse(0);
*/
        Graph g = new Graph(7);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(1, 0);
        g.addEdges(2, 3);
        g.addEdges(2, 1);
        g.addEdges(3, 4);
        g.addEdges(3, 2);
        g.addEdges(4, 5);
        g.addEdges(4, 3);
        g.addEdges(5, 6);
        g.addEdges(5, 4);

        g.iterativeDFSTraverse(4);
        g.iterativeBFSTraverse(4);
//        g.recursiveDFSTraverse(0);
    }

    public void iterativeDFSTraverse(int startVertex) {
        System.out.print("DFS: ");

        Stack<Integer> nodes = new Stack<Integer>();
        nodes.push(startVertex);
        boolean[] visited = new boolean[this.graphSize];
        while(!nodes.empty()) {
            int top = nodes.pop();
            if (!visited[top]) {
                System.out.print(top + " ");
                visited[top] = true;
            }
            for (int i=0; i < this.edges[top].size(); i++) {
                int vertex = this.edges[top].get(i);
                if (!visited[vertex]) {
                    nodes.push(vertex);
                }
            }
        }
        System.out.println();
    }

    public void iterativeBFSTraverse(int startVertex) {
        System.out.print("BFS: ");
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        nodes.add(startVertex);
        boolean[] visited = new boolean[this.graphSize];
        while(!nodes.isEmpty()) {
            int top = nodes.removeFirst();
            if (!visited[top]) {
                System.out.print(top + " ");
                visited[top] = true;
            }
            for (int i=0; i < this.edges[top].size(); i++) {
                int vertex = this.edges[top].get(i);
                if (!visited[vertex]) {
                    nodes.addLast(vertex);
                }
            }
        }
        System.out.println();
    }
}