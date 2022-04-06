package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphProject {
	public static void main(String[] args) {
//		final String filePath = "D:\\UNCC\\SEM 2\\ITCS 8114 - Algorithms and Data Structures\\PROJECT 2\\graphproj\\src\\input.txt";
		final String filePath = "../input.txt";
		try {
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
			Graph graph = new Graph(edgeList, direction);
			graph.printGraph();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
