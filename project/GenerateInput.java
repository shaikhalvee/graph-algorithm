package project;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateInput {
	public static void main(String[] args) throws IOException {
		final String outputFile = "src/input1.txt";
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
		for (int i = 0; i < loop; i++) {
			int vertex, edge;
			vertex = scanner.nextInt();
			edge = scanner.nextInt();
			bufferedWriter.write(vertex + " " + edge + "\n");
			for (int j = 0; j < edge; j++) {

			}
		}
//		for (int i = 0; i < 2; i++) {
//			Integer vertexU = ThreadLocalRandom.current().nextInt(10, 101);
//			Integer vertexD = ThreadLocalRandom.current().nextInt(11, 101);
//			Integer edgeU = ThreadLocalRandom.current().nextInt(14, 101);
//			Integer edgeU = ThreadLocalRandom.current().nextInt(14, 101);
//		}
	}
}
