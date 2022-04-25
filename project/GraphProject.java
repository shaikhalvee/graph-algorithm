package project;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphProject {
	public static void doSimulation() throws Exception {
		singleSourceShortestPath();
		minimumSpanningTree();
		stronglyConnectedComponents();
	}

	static void singleSourceShortestPath() throws IOException {
		final String inputFilepath = "src/input1.txt";
		final String outputFilepath = "src/output1.txt";
		Scanner scanner = new Scanner(Files.newInputStream(Paths.get(inputFilepath)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilepath));
		int loop;
		loop = scanner.nextInt();
		for (int j = 0; j < loop; j++) {
			Graph graph = prepareGraph(scanner);
			char source = scanner.next().charAt(0);
			writer.write(String.format("Graph no: %d\n", j));
			graph.printGraph(writer);
			writer.write("\nShortest paths:\n");
			writer.write(Dijkstra.doDijkstra(graph, source).toCharArray());
//			writer.write(BellmanFord.doBellmanFord(graph, source).toCharArray());
			writer.write("============================================\n\n");
			writer.flush();
		}
		writer.close();
	}

	static void minimumSpanningTree() throws IOException {
		final String inputFilepath = "src/input2.txt";
		final String outputFilepath = "src/output2.txt";
		Scanner scanner = new Scanner(Files.newInputStream(Paths.get(inputFilepath)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilepath));
		int loop;
		loop = scanner.nextInt();
		for (int j = 0; j < loop; j++) {
			Graph graph = prepareGraph(scanner);
			writer.write(String.format("Graph no: %d\n", j));
			graph.printGraph(writer);
			List<Edge> mstEdges = Kruskal.doKruskal(graph);
			writer.write(String.format("\nmst edges : %s\n", mstEdges));
			writer.write(String.format("mst cost : %d\n", Kruskal.minCost(mstEdges)));
			writer.write("============================================\n\n");
			writer.flush();
		}
		writer.close();
	}

	static void stronglyConnectedComponents() throws IOException {
		final String inputFilepath = "src/input3.txt";
		final String outputFilepath = "src/output3.txt";
		Scanner scanner = new Scanner(Files.newInputStream(Paths.get(inputFilepath)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilepath));
		int loop;
		loop = scanner.nextInt();
		for (int j = 0; j < loop; j++) {
			Graph graph = prepareGraph(scanner);
			writer.write(String.format("Graph no: %d\n", j));
			graph.printGraph(writer);
			writer.write("\nStrongly connected components:\n");
			StronglyConnectedComponents.printStronglyConnectedComponents(graph, writer);
			writer.write("============================================\n\n");
			writer.flush();
		}
		writer.close();
	}

	static private Graph prepareGraph(Scanner scanner) {
		List<Edge> edgeList = new ArrayList<>();
		int vertex, edgeNum;
		char direction;
		vertex = scanner.nextInt();
		edgeNum = scanner.nextInt();
		direction = scanner.next().charAt(0);
		for (int i = 0; i < edgeNum; i++) {
			Edge edge = new Edge();
			edge.source = scanner.next().charAt(0);
			edge.dest = scanner.next().charAt(0);
			edge.weight = scanner.nextInt();
			edgeList.add(edge);
		}
		return new Graph(edgeList, direction);
	}
}
