package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisjointSet {
	Map<Character, Character> parentMap;

	DisjointSet() {
		parentMap = new HashMap<>();
	}

	public void makeSet(Set<Character> vertices) {
		for (Character currentVertex: vertices) {
			parentMap.put(currentVertex, currentVertex);
		}
	}

	public Character findSet(Character vertex) {
		if (parentMap.get(vertex) == vertex) {
			return vertex;
		}
		return findSet(parentMap.get(vertex));
	}

	public void unionSet(Character vertex1, Character vertex2) {
		parentMap.put(findSet(vertex1), findSet(vertex2));
	}
}
