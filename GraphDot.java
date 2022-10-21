import java.io.*;

/**
 * File Name: GraphDot.java
 * 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

class GraphDot{
	private Graph g ;
	private String fname;
	//You can have any number of private variables
	
	GraphDot(Graph g, String n) {
		this.g = g ;
		this.fname = n ;
		dump() ;
	}
	
	/******************************************************************
									WRITE YOUR CODE BELOW
	 ******************************************************************/
	private void dump() {
		if (false) {
			try {
				System.setOut(new PrintStream(new FileOutputStream(fname)));

				System.out.println("digraph g {");
				if(g.type==GraphType.Type.UNDIRECTED) {
					System.out.println("edge [dir=none, color=red]");
					for (Node n : g.nodes) {
						for (Node m : g.nodes) {
							if (n.num != m.num && n.hasAFanoutEdge(m.num) != null) {
								if (m.num > n.num) {
									System.out.println(g.io.getRealName(n.num) + " -> " + g.io.getRealName(n.hasAFanoutEdge(m.num).other));
								}
							}
						}
					}
					System.out.println("}");
				}
				else if(g.type==GraphType.Type.WEIGHTED_UNDIRECTED){
					System.out.println("edge [dir=none, color=red]");
					for (Node n : g.nodes) {
						for (Node m : g.nodes) {
							if (n.num != m.num && n.hasAFanoutEdge(m.num) != null) {
								if (m.num > n.num) {
									System.out.print(g.io.getRealName(n.num) + " -> " + g.io.getRealName(n.hasAFanoutEdge(m.num).other));
									System.out.println(" [label = "+ n.hasAFanoutEdge(m.num).cost+"]");
								}
							}
						}
					}
					System.out.println("}");

				}

				else if(g.type==GraphType.Type.WEIGHTED_DIRECTED){
					System.out.println("edge [color=red]");
					for (Node n : g.nodes) {
						for (Node m : g.nodes) {
							if (n.num != m.num && n.hasAFanoutEdge(m.num) != null) {
								System.out.print(g.io.getRealName(n.num) + " -> " + g.io.getRealName(n.hasAFanoutEdge(m.num).other));
								System.out.println(" [label = "+ n.hasAFanoutEdge(m.num).cost+"]");
							}
						}
					}
					System.out.println("}");

				}
				else{
					System.out.println("edge [color=red]");
					for (Node n : g.nodes) {
						for (Node m : g.nodes) {
							if (n.num != m.num && n.hasAFanoutEdge(m.num) != null) {
								System.out.println(g.io.getRealName(n.num) + " -> " + g.io.getRealName(n.hasAFanoutEdge(m.num).other));
							}
						}
					}
					System.out.println("}");

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}