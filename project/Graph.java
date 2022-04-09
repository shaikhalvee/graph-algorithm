package project;

import java.util.*;

public class Graph {
	HashMap<Character, Set<Edge>> adjacencyList;
	Set<Edge> edges;
	Set<Character> vertices;

	Graph(List<Edge> edgeList, char direction) {
		adjacencyList = new HashMap<>();
		edges = new HashSet<>();
		vertices = new HashSet<>();
		for (Edge edge : edgeList) {
			edges.add(edge);
			vertices.add(edge.source);
			vertices.add(edge.dest);
		}
		for (Character vertex: vertices) {
			adjacencyList.put(vertex, new HashSet<>());
		}
		for (Edge edge : edgeList) {
			switch (direction) {
				case 'D':
				case 'd':
					adjacencyList.get(edge.source).add(edge);
					break;
				case 'U':
				case 'u':
					adjacencyList.get(edge.source).add(new Edge(edge.source, edge.dest, edge.weight));
					adjacencyList.get(edge.dest).add(new Edge(edge.dest, edge.source, edge.weight));
					break;
				default:
					throw new IllegalArgumentException("Illegal direction provided : " + direction);
			}
		}
	}

	public Set<Character> getVertices() {
		return vertices;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public void printGraph() {
		for (Character sourceNode : adjacencyList.keySet()) {
			System.out.print(sourceNode + ": ");
			printEdgesForANode(adjacencyList.get(sourceNode));
			System.out.println();
		}
	}

	private void printEdgesForANode(Set<Edge> edgeListOfNode) {
		for (Edge edge : edgeListOfNode) {
			System.out.print("(" + edge.source + ", " + edge.dest + ")-{" + edge.weight + "} ");
		}
	}

	public void clearGraph() {
		vertices.clear();
		edges.clear();
		adjacencyList.clear();
	}
}
