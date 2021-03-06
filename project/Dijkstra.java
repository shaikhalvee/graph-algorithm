package project;

import java.util.*;

public class Dijkstra {
	public static String doDijkstra(Graph graph, Character source) {
		Node srcVtx = new Node(source, 0);

		PriorityQueue<Node> minHeapForNodes = new PriorityQueue<>();
		minHeapForNodes.add(srcVtx);

		Map<Character, Integer> distance = new HashMap<>();
		for (Character currentVtx : graph.getVertices()) {
			distance.put(currentVtx, Integer.MAX_VALUE);
		}
		distance.put(source, 0);
		Map<Character, Boolean> visited = new HashMap<>();
		for (Character currentVtx : graph.getVertices()) {
			visited.put(currentVtx, false);
		}
		visited.put(source, true);
		Map<Character, Character> previousVertex = new HashMap<>();
		for (Character currentVtx : graph.getVertices()) {
			previousVertex.put(currentVtx, '0');
		}

		while (!minHeapForNodes.isEmpty()) {
			Node currentNode = minHeapForNodes.poll();
			Character currentVertex = currentNode.vertex;
			for (Edge currentEdge : graph.getAdjacencyList().get(currentVertex)) {
				Character destinationVertex = currentEdge.dest;
				Integer currentEdgeWeight = currentEdge.weight;
				if (!visited.get(destinationVertex) &&
						(distance.get(currentVertex) + currentEdgeWeight) < distance.get(destinationVertex)) {
					distance.put(destinationVertex, distance.get(currentVertex) + currentEdgeWeight);
					previousVertex.put(destinationVertex, currentVertex);
					Node childNodeToAdd = new Node(destinationVertex, distance.get(destinationVertex));
					minHeapForNodes.add(childNodeToAdd);
				}
			}
			visited.put(currentVertex, true);
		}
		return printShortestPath(graph, source, distance, previousVertex);
	}

	private static String printShortestPath(Graph graph,
	                                        Character source,
	                                        Map<Character, Integer> distance,
	                                        Map<Character, Character> previousVertex) {
		List<Character> shortestPath = new ArrayList<>();
		StringBuilder fullList = new StringBuilder();
		for (Character vertex : graph.getVertices()) {
			Character currentVertex = vertex;
			while (currentVertex != '0') {
				shortestPath.add(currentVertex);
				currentVertex = previousVertex.get(currentVertex);
			}
			Collections.reverse(shortestPath);
			if (shortestPath.size() == 1 && shortestPath.get(0) != source) {
				fullList.append(String.format("There is no path from Node %c -> %c\n", source, vertex));
			} else {
				fullList.append(String.format("Node %c -> %c :: Min Cost %d :: Shortest Path %s\n",
						source, vertex, distance.get(vertex), shortestPath));
			}
			shortestPath.clear();
		}
		return fullList.toString();
	}
}
