package project;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Temp {
	public static void main(String[] args) {
		Node a = new Node('A', 5);
		Node b = new Node('B', 3);
		Node c = new Node('C', 2);
		Node d = new Node('D', 7);
		Node e = new Node('E', 9);
		PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();
		nodePriorityQueue.add(a);
		nodePriorityQueue.add(b);
		nodePriorityQueue.add(c);
		nodePriorityQueue.add(d);
		nodePriorityQueue.add(e);
		System.out.println(nodePriorityQueue);
		Map<Character, Boolean> hello = new HashMap<>();
		hello.put('a',true);
		hello.put('b',true);
		hello.put('c',true);
		hello.put('d',true);
		hello.put('e',true);
		hello.replaceAll((key, value)->false);
		System.out.println(hello);
	}
}
