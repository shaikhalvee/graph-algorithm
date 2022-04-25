package project;

import java.util.HashMap;
import java.util.Map;

public class BellmanFord {
	public static String doBellmanFord(Graph graph, Character source) {
		Map<Character, Integer> distance = new HashMap<>();
		for (Character currentVtx : graph.getVertices()) {
			distance.put(currentVtx, Integer.MAX_VALUE);
		}
		distance.put(source, 0);
		for (int i = 0; i < graph.getEdges().size(); i++) {
			for (Edge currentEdge: graph.getEdges()) {
				if (distance.get(currentEdge.source) != Integer.MAX_VALUE
						&& distance.get(currentEdge.source) + currentEdge.weight < distance.get(currentEdge.dest)) {
					distance.put(currentEdge.dest, distance.get(currentEdge.source) + currentEdge.weight);
				}
			}
		}
		for (Edge currentEdge: graph.getEdges()) {
			if (distance.get(currentEdge.source) != Integer.MAX_VALUE
					&& distance.get(currentEdge.source) + currentEdge.weight < distance.get(currentEdge.dest)) {
				return "No Solution. Has Negative Edges\n";
			}
		}
		return printShortestPath(graph, source, distance);
	}

	private static String printShortestPath(Graph graph, Character source, Map<Character, Integer> distance) {
		StringBuilder value = new StringBuilder();
		for(Character node: distance.keySet()) {
			value.append(String.format("distance from %s to %s is : %d\n", source, node, distance.get(node)));
		}
		return value.toString();
	}
}
