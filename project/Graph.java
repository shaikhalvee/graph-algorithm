package project;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Graph {
	HashMap<Character, Set<Edge>> adjacencyList;
	Set<Edge> edges;
	Set<Character> vertices;
	Character direction;

	Graph(List<Edge> edgeList, char direction) {
		this.direction = direction;
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
			System.out.printf("%s: ", sourceNode);
			printEdgesForANode(adjacencyList.get(sourceNode));
			System.out.println();
		}
	}

	public void printGraph(Writer writer) throws IOException {
		for (Character sourceNode : adjacencyList.keySet()) {
			writer.write(String.format("%s: ", sourceNode));
			printEdgesForANode(adjacencyList.get(sourceNode), writer);
			writer.write("\n");
		}
	}

	private void printEdgesForANode(Set<Edge> edgeListOfNode) {
		for (Edge edge : edgeListOfNode) {
			System.out.printf("(%c, %c)-{%d} ", edge.source, edge.dest, edge.weight);
		}
	}

	private void printEdgesForANode(Set<Edge> edgeListOfNode, Writer writer) throws IOException {
		for (Edge edge : edgeListOfNode) {
			writer.write(String.format("(%c, %c)-{%d} ", edge.source, edge.dest, edge.weight));
		}
	}

	public Graph transpose() {
		List<Edge> reversedEdgeList = new ArrayList<>();
		for (Edge edge : this.getEdges()) {
			Edge reversedEdge = new Edge(edge.dest, edge.source, edge.weight);
			reversedEdgeList.add(reversedEdge);
		}
		return new Graph(reversedEdgeList, this.direction);
	}

	public void clearGraph() {
		vertices.clear();
		edges.clear();
		adjacencyList.clear();
	}
}
