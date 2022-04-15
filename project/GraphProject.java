package project;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphProject {
	public static void doSimulation() throws Exception {
//		final String filePath = "D:\\UNCC\\SEM 2\\ITCS 8114 - Algorithms and Data Structures\\PROJECT 2\\graphproj\\src\\input.txt";
		final String filePath = "src/input.txt";
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(fileInputStream);
		int vertex, edgeNum;
		char direction;
		vertex = scanner.nextInt();
		edgeNum = scanner.nextInt();
		direction = scanner.next().charAt(0);
		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < edgeNum; i++) {
			Edge edge = new Edge();
			edge.source = scanner.next().charAt(0);
			edge.dest = scanner.next().charAt(0);
			edge.weight = scanner.nextInt();
			edgeList.add(edge);
		}
		char source = scanner.next().charAt(0);
		Graph graph = new Graph(edgeList, direction);
		graph.printGraph();
//		Dijkstra.doDijkstra(graph, source);
//		List<Edge> kruskal = Kruskal.doKruskal(graph);
//		System.out.println(kruskal);
//		System.out.printf("min value %d\n", Kruskal.minCost(kruskal));
//		System.out.println("ssc " + StronglyConnectedComponents.isStronglyConnected(graph));
		StronglyConnectedComponents.printStronglyConnectedComponents(graph);
	}
}
