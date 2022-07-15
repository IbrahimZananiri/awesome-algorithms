# Graph

## Graph Data Structure
In graph theory, a graph is a group of nodes called *vertices*, connected via connections (relationships) called *edges*.

Edges can be directed, making a *directed graph*, or an *undirected graph otherwise*.

An edge can be extended to hold a *weight* (e.g. road distance, connection latency, cost). Graphs with such edges are called *Weighted Graphs*.

A *path* on a graph is a sequence of connected nodes that allow traversal from vertex X to vertex Y.

## Graph Representation

### Adjacency Matrix

An adjacency matrix is a matrix (a 2D array) of V x V vertices. Each row and column represent a vertex.

If the value of any element a[row][column] is True (or non-falsey), it represents that there is an edge connecting vertex i and vertex j. The value can hold the weight of the edge as well.

For undirected graphs, the matrix would be symmetric around the diagonal. Otherwise, for a directed graph, the matrix would be asymmetric.

The value can be a boolean indicating the presence of a relationship, or numeric, holding the weight value of the directed edge like the representation below:

|   | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| 0 | 0 | 1 | 0 | 2 |
| 1 | 1 | 0 | 1 | 0 |
| 2 | 1 | 1 | 0 | 0 |
| 3 | 0 | 4 | 3 | 0 |

Adjacency matrices are fast in single-edge look up, as the array data structure provides constant time random access to graph[from][to] values. The tradeoff is the space requirement for the 2-D array.

### Adjacency List

An adjacency list is an array (or map) keyed by Vertex identifier, with values being lists of vertices that have a relationship (edge) with the source node.

Adjacency List representation is efficient in terms of space.

### Edge List

A list of all edges on a graph, where an edge indicates the source and destination nodes, as well as an optional edge weight.

This representation is ideal for sparce graphs that do not hold many edges.


## Use cases
- Social networks
- Road networks

## Graph Algorithms
- Breadth-First Search
- [Dijkstra's Shortest Path Algorithm](dijkstra)
- Bellman-Ford-Moore Algorithm
