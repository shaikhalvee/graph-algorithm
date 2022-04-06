package project;

public class Edge {
	Character source;
	Character dest;
	Integer weight;

	Edge() {
	}

	Edge(Character var1, Character var2, Integer var3) {
		this.source = var1;
		this.dest = var2;
		this.weight = var3;
	}
}
