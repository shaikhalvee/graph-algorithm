package project;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class StronglyConnectedComponents {
	public static Boolean isStronglyConnected(Graph graph) {
		Map<Character, Boolean> visited = new HashMap<>();
		for (Character vertex : graph.getVertices()) {
			visited.put(vertex, false);
		}
		// taking a random node
		Character source = graph.getVertices().iterator().next();
		DFS.dfsVisit(graph, source, visited);
		for (Character vertex : visited.keySet()) {
			if (!visited.get(vertex)) {
				return false;
			}
		}
		visited.replaceAll((key, value) -> false);
		List<Edge> reversedEdgeList = new ArrayList<>();
		for (Edge edge : graph.getEdges()) {
			Edge reversedEdge = new Edge(edge.dest, edge.source, edge.weight);
			reversedEdgeList.add(reversedEdge);
		}
		Graph transposeGraph = new Graph(reversedEdgeList, graph.getDirection());
		DFS.dfsVisit(transposeGraph, source, visited);
		for (Character vertex : visited.keySet()) {
			if (!visited.get(vertex)) {
				return false;
			}
		}
		return true;
	}

	public static void printStronglyConnectedComponents(Graph graph, Writer writer) throws IOException {
		Stack<Character> nodes = new Stack<>();
		Map<Character, Boolean> visited = new HashMap<>();
		for (Character vertex : graph.getVertices()) {
			visited.put(vertex, false);
		}
		for (Character currentVertex : graph.getVertices()) {
			if (!visited.get(currentVertex)) {
				fillStackOrder(graph, currentVertex, visited, nodes);
			}
		}
		visited.replaceAll((key, value) -> false);
		Graph transposedGraph = graph.transpose();
		List<Character> connectedNodes = new ArrayList<>();
		while (!nodes.empty()) {
			Character currentNode = nodes.pop();
			if (!visited.get(currentNode)) {
				DFS.dfsVisitForStrongConnection(transposedGraph, currentNode, visited, connectedNodes);
				writer.write(String.format("%s\n", connectedNodes));
				connectedNodes.clear();
			}
			writer.flush();
		}
	}

	synchronized private static void fillStackOrder(Graph graph,
	                                                Character currentVertex,
	                                                Map<Character, Boolean> visited,
	                                                Stack<Character> stackOfNodes) {
		visited.put(currentVertex, true);
		for (Edge connectedEdge : graph.getAdjacencyList().get(currentVertex)) {
			if (!visited.get(connectedEdge.dest)) {
				fillStackOrder(graph, connectedEdge.dest, visited, stackOfNodes);
			}
		}
		stackOfNodes.push(currentVertex);
	}
}
