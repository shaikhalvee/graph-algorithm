package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StronglyConnectedComponents {
	public Boolean isStronglyConnected(Graph graph, Character source) {
		Map<Character, Boolean> visited = new HashMap<>();
		for(Character vertex: graph.getVertices()) {
			visited.put(vertex, false);
		}
		DFS.dfsVisit(graph, source, visited);
		for(Character vertex: visited.keySet()) {
			if (!visited.get(vertex)) {
				return false;
			}
		}
		visited.replaceAll((key, value) -> false);
		List<Edge> reversedEdgeList = new ArrayList<>();
		for(Edge edge: graph.getEdges()) {
			Edge reversedEdge = new Edge(edge.dest, edge.source, edge.weight);
			reversedEdgeList.add(reversedEdge);
		}
		Graph transposeGraph = new Graph(reversedEdgeList, graph.direction);
		DFS.dfsVisit(transposeGraph, source, visited);
		for(Character vertex: visited.keySet()) {
			if (!visited.get(vertex)) {
				return false;
			}
		}
		return true;
	}
}
