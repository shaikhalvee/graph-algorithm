package project;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Graph {
	 private HashMap<Character, Set<Edge>> adjacencyList;
	private Set<Edge> edges;
	private Set<Character> vertices;
	private Character direction;

	Graph(List<Edge> edgeList, char direction) {
		this.setDirection(direction);
		setAdjacencyList(new HashMap<>());
		setEdges(new HashSet<>());
		setVertices(new HashSet<>());
		for (Edge edge : edgeList) {
			getEdges().add(edge);
			getVertices().add(edge.source);
			getVertices().add(edge.dest);
		}
		for (Character vertex: getVertices()) {
			getAdjacencyList().put(vertex, new HashSet<>());
		}
		for (Edge edge : edgeList) {
			switch (direction) {
				case 'D':
				case 'd':
					getAdjacencyList().get(edge.source).add(edge);
					break;
				case 'U':
				case 'u':
					getAdjacencyList().get(edge.source).add(new Edge(edge.source, edge.dest, edge.weight));
					getAdjacencyList().get(edge.dest).add(new Edge(edge.dest, edge.source, edge.weight));
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
		for (Character sourceNode : getAdjacencyList().keySet()) {
			System.out.printf("%s: ", sourceNode);
			printEdgesForANode(getAdjacencyList().get(sourceNode));
			System.out.println();
		}
	}

	public void printGraph(Writer writer) throws IOException {
		for (Character sourceNode : getAdjacencyList().keySet()) {
			writer.write(String.format("%s: ", sourceNode));
			printEdgesForANode(getAdjacencyList().get(sourceNode), writer);
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
		return new Graph(reversedEdgeList, this.getDirection());
	}

	public void clearGraph() {
		getVertices().clear();
		getEdges().clear();
		getAdjacencyList().clear();
	}

	public HashMap<Character, Set<Edge>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(HashMap<Character, Set<Edge>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public void setVertices(Set<Character> vertices) {
		this.vertices = vertices;
	}

	public Character getDirection() {
		return direction;
	}

	public void setDirection(Character direction) {
		this.direction = direction;
	}
}
