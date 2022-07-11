# Dijkstra's Shortest Path Algorithm

Family: [Graph](../)

## Goal

Find the shortest distance and shortest path to get from origin node to any reachable node on a weighted graph.

## Mechanism

Eagerly, for each unvisited node, determine the shortest accumulated distance and the previous node in the most optimal path to get to that node from Origin node.

To determine the most optimal path to get to Destination node, walk back from Destination node's previous node until you reach Origin node, and reverse that path.

[Watch video on YouTube](https://www.youtube.com/watch?v=pVfj6mxhdMw)

[![Dijkastra's Algorithm Video](https://img.youtube.com/vi/pVfj6mxhdMw/0.jpg)](https://www.youtube.com/watch?v=pVfj6mxhdMw "Watch video on YouTube")


## Applications

- Maps Navigation

## Time Complexity

O(E*Log(V))

where E is the number of edges, and V is the number of vertices.
