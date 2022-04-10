package project;

public class Edge implements Comparable<Edge> {
	Character source;
	Character dest;
	Integer weight;

	Edge() {
	}

	Edge(Character source, Character destination, Integer weight) {
		this.source = source;
		this.dest = destination;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return "Edge{" +
				"source=" + source +
				", dest=" + dest +
				", weight=" + weight +
				'}';
	}
}
