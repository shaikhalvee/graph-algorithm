package project;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerateInput {
	public static void main(String[] args) throws IOException {
		final String outputFile = "src/output.txt";
		final String inputFile = "src/input1.txt";
		FileWriter fileWriter;
		FileReader fileReader;
		BufferedWriter bufferedWriter;
		try {
			fileReader = new FileReader(inputFile);
			fileWriter = new FileWriter(outputFile);
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Scanner scanner = new Scanner(fileReader);
		int loop = scanner.nextInt();
		bufferedWriter.write(loop + "\n");
//		bufferedWriter.newLine();
		for (int i = 0; i < loop; i++) {
			int vertex, edge;
			vertex = scanner.nextInt();
			edge = scanner.nextInt();
			bufferedWriter.write(vertex + " " + edge + "\n");
			for (int j = 0; j < edge; j++) {
				int node1, node2, weight;
				node1 = scanner.nextInt();
				node2 = scanner.nextInt();
				weight = scanner.nextInt();
				char node_1 = (char) (node1 + 'A');
				char node_2 = (char) (node2 + 'A');
				bufferedWriter.write(node_1 + " " + node_2 + " " + weight + "\n");
			}
		}
		bufferedWriter.close();
		scanner.close();
//		for (int i = 0; i < 2; i++) {
//			Integer vertexU = ThreadLocalRandom.current().nextInt(10, 101);
//			Integer vertexD = ThreadLocalRandom.current().nextInt(11, 101);
//			Integer edgeU = ThreadLocalRandom.current().nextInt(14, 101);
//			Integer edgeU = ThreadLocalRandom.current().nextInt(14, 101);
//		}
	}
}
