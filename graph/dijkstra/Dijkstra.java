package graphs;

import java.util.*;

public class Dijkstra {

    record Edge(int targetNode, int weight) { }
    record Route(int distance, List<Integer> path) { }

    class Hop {
        final int currentNode;
        int previousNode;
        int accumulatedDistance; // shortest from Origin

        Hop(int curr, int prev, int accDist) {
            currentNode = curr;
            previousNode = prev;
            accumulatedDistance = accDist;
        }
    }

    private Hop[] optimizedHops(List<Edge>[] graph, int origin, int destination) {
        Hop[] optimizedHops = new Hop[graph.length];
        for (int i = 0; i < optimizedHops.length; i++) {
            int distance = (i == origin) ? 0 : Integer.MAX_VALUE;
            optimizedHops[i] = new Hop(i, -1, distance);
        }
        boolean[] isVisited = new boolean[graph.length];
        Queue<Hop> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.accumulatedDistance, b.accumulatedDistance);
        });
        pq.add(optimizedHops[origin]);
        while (!pq.isEmpty()) {
            Hop hop = pq.poll();
            isVisited[hop.currentNode] = true;
            for (Edge edge : graph[hop.currentNode]) {
                if (isVisited[edge.targetNode]) continue;
                Hop targetHop = optimizedHops[edge.targetNode];
                int distance = hop.accumulatedDistance + edge.weight;
                if (distance < targetHop.accumulatedDistance) {
                    targetHop.previousNode = hop.currentNode;
                    targetHop.accumulatedDistance = distance;
                    pq.add(targetHop);
                }
            }
            // Optimization:
            // Stop early after the destination node has been found and processed
            if (hop.currentNode == destination) {
                return optimizedHops;
            }
        }
        return optimizedHops;
    }

    Route optimalRoute(List<Edge>[] graph, int origin, int destination) {
        Hop[] optimizedHops = optimizedHops(graph, origin, destination);
        List<Integer> optimalRoute = new ArrayList<>();
        Hop currentHop = optimizedHops[destination];
        if (currentHop.previousNode == -1) {
            return null;
        }
        optimalRoute.add(destination);
        while (currentHop.previousNode != -1) {
            optimalRoute.add(currentHop.previousNode);
            currentHop = optimizedHops[currentHop.previousNode];
        }
        Collections.reverse(optimalRoute);
        return new Route(optimizedHops[destination].accumulatedDistance, optimalRoute);
    }

    public static void main(String[] args) {
        List<Edge>[] graph = new List[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1, 4));
        graph[0].add(new Edge(2, 1));

        graph[1].add(new Edge(3, 1));

        graph[2].add(new Edge(1, 2));
        graph[2].add(new Edge(3, 5));

        graph[3].add(new Edge(4, 3));

        Dijkstra dijkstra = new Dijkstra();
        Route route = dijkstra.optimalRoute(graph, 0, 4);

        System.out.println(route);
      
        // Prints:
        // Route[distance=7, path=[0, 2, 1, 3, 4]]

    }
}
