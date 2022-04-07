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
					// for directed graph
					adjacencyList.computeIfAbsent(edge.source, k -> new ArrayList<>());
					adjacencyList.get(edge.source).add(edge);
					break;
				case 'U':
				case 'u':
					// for undirected graph
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

	public Set<Character> getVertices() {
		return adjacencyList.keySet();
	}

	public void printGraph() {
		for (Character sourceNode : adjacencyList.keySet()) {
			System.out.print(sourceNode + ": ");
			printEdgeSet(adjacencyList.get(sourceNode));
			System.out.println();
		}
	}

	private void printEdgeSet(List<Edge> edgeSet) {
		for (Edge edge : edgeSet) {
			System.out.print("(" + edge.source + ", " + edge.dest + ")-{" + edge.weight + "} ");
		}
	}
}
