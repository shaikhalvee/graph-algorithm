package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph {
	HashMap<Character, List<Edge>> adjacencyList;

	Graph() {
		adjacencyList = null;
	}

	Graph(List<Edge> edgeList, char direction) {
		adjacencyList = new HashMap<>();
		for (Edge edge : edgeList) {
			switch (direction) {
				case 'D':
				case 'd':
					adjacencyList.computeIfAbsent(edge.source, k -> new ArrayList<>());
					adjacencyList.get(edge.source).add(edge);
					break;
				case 'U':
				case 'u':
					adjacencyList.computeIfAbsent(edge.source, k -> new ArrayList<>());
					adjacencyList.get(edge.source).add(new Edge(edge.source, edge.dest, edge.weight));
					adjacencyList.computeIfAbsent(edge.dest, k -> new ArrayList<>());
					adjacencyList.get(edge.dest).add(new Edge(edge.dest, edge.source, edge.weight));
					break;
				default:
					throw new IllegalArgumentException("Illegal direction provided : " + direction);
			}
		}
	}

	public void printGraph() {
		for (Character sourceNode : adjacencyList.keySet()) {
			System.out.println(sourceNode + ": " + adjacencyList.get(sourceNode));
		}
	}

	private String printEdgeSet(Set<Edge> edgeSet) {
		for (Edge edge : edgeSet) {
			return "(" + edge.source + ", " + edge.dest + ")-{" + edge.weight + "}, ";
		}
		return "";
	}
}
