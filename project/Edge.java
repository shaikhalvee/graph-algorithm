package project;

public class Edge {
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
}
