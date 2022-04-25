package project;

import java.util.List;
import java.util.Map;

public class DFS {
	synchronized public static void dfsVisit(Graph graph,
	                                         Character currentVertex,
	                                         Map<Character, Boolean> visited) {
		visited.put(currentVertex, true);
		for (Edge connectedEdge : graph.getAdjacencyList().get(currentVertex)) {
			if (connectedEdge.dest != currentVertex && !visited.get(connectedEdge.dest)) {
				dfsVisit(graph, connectedEdge.dest, visited);
			}
		}
	}

	synchronized public static void dfsVisitForStrongConnection(Graph graph,
	                                                            Character currentVertex,
	                                                            Map<Character, Boolean> visited,
	                                                            List<Character> connectedNodes) {
		visited.put(currentVertex, true);
		connectedNodes.add(currentVertex);
		for (Edge connectedEdge : graph.getAdjacencyList().get(currentVertex)) {
			if (!visited.get(connectedEdge.dest)) {
				dfsVisitForStrongConnection(graph, connectedEdge.dest, visited, connectedNodes);
			}
		}
	}
}
