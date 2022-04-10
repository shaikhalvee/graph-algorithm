package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	public static List<Edge> doKruskal(Graph graph) {
		List<Edge> mstTree = new ArrayList<>();

		DisjointSet disjointSet = new DisjointSet();
		disjointSet.makeSet(graph.getVertices());

		List<Edge> edgeList = new ArrayList<>(graph.getEdges());
		Collections.sort(edgeList);

		for (Edge currentEdge: edgeList) {
			Character sourceParent = disjointSet.findSet(currentEdge.source);
			Character destParent = disjointSet.findSet(currentEdge.dest);
			if (sourceParent != destParent) {
				mstTree.add(currentEdge);
				disjointSet.unionSet(sourceParent, destParent);
			}
		}
		return mstTree;
	}
}
