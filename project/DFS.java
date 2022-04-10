package project;

import java.util.Map;

public class DFS {
	public static void dfsVisit(Graph graph,
	                            Character currentVertex,
	                            Map<Character, Boolean> visited) {
		visited.put(currentVertex, true);
		for (Edge connectedEdge : graph.adjacencyList.get(currentVertex)) {
			if (connectedEdge.dest != currentVertex  && !visited.get(connectedEdge.dest)) {
				dfsVisit(graph, connectedEdge.dest, visited);
			}
		}
	}
}
