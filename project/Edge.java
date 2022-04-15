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

	Edge(Character source, Character destination) {
		this.source = source;
		this.dest = destination;
		this.weight = 0;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return String.format("(%c, %c)-{%d} ", this.source, this.dest, this.weight);
	}
}
