## Files

Please go to the folder where codes are.

	cd project/

## JDK Version

JDK version should be greater than 1.8

	$ java -version
	java version "1.8.0_221"
	Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
	Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)

## Command to run the code

	javac DFS.java DisjointSet.java GraphProject.java Main.java StronglyConnectedComponents.java Dijkstra.java Edge.java Graph.java Kruskal.java Node.java

	java -classpath ../ project.Main

## Input files

In the `/project/src`  folder the `input1.txt` for problem 1, `input2.txt` for problem 2 and `input3.txt` for problem 3 is given.
__N.B. direction of the graph must be given, otherwise it will show error__
	For example, in `input3.txt` you have to provide D for the direction.
**Here 4 inputs are provided. But if you want you can have as many as you want. In the first line of the file, it's specified how many graphs are provided as input. You just have to replace 4 with the number you want to test with**

## Output files
The outputs will be corresponding `output1.txt` for problem 1, `output2.txt` for problem 2 and `output3.txt` for problem 3 in the `/project/src` folder.

## The problems
Problem 1: Single-source Shortest Path Algorithm

Find shortest path tree in both directed and undirected weighted graphs for a given source vertex. Assume there is no negative edge in your graph. You will print each path and path cost for a given source.


Problem 2: Minimum Spanning Tree Algorithm

Given a connected, undirected, weighted graph, find a spanning tree using edges that minimizes the total weight. Use either Kruskal's or Prim's algorithm to find Minimum Spanning Tree (MST). You will printout edges of the tree and total cost of minimum spanning tree.

Problem 3: Finding Strongly Connected Components

Given a directed graph G with n vertices and m edges. This graph may not be simple. Decompose this graph into Strongly Connected Components (SCCs) and print the components. You can use the same input format defined below.  

