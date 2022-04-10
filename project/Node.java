package project;

public class Node implements Comparable<Node> {
	Character vertex;
	Integer weight;

	Node() {
	}

	Node(Character vertex, Integer weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return "Node{" +
				"vertex=" + vertex +
				", weight=" + weight +
				'}';
	}
}
