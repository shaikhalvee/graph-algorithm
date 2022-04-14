package project;

public class Main {
	public static void main(String[] args) {
		try {
			GraphProject.doSimulation();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
