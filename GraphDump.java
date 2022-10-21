import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * File Name: GraphDump.java
 * 
 * 
 */

class GraphDump{
	private Graph g ;
	private String name;
	boolean dealout=true;
	boolean dealin=true;
	
	GraphDump(Graph g, String n) {
		this.g = g ;
		this.name = n ;
		dump() ;
	}
	
	private void dump() {

        if(true) {
			System.out.println("------------ " + name + " ------------");
			System.out.println("GraphType." + g.type);
			System.out.println("Num Vertices = " + g.numV());
			System.out.println("Num Edges = " + g.numE());
			for (Node n : g.nodes) {
				System.out.print(g.io.getRealName(n.num) + " Fanouts: ");
				for (Node m : g.nodes) {
					if (n.num != m.num && n.hasAFanoutEdge(m.num) != null) {
						dealout = false;
						System.out.print(g.io.getRealName(n.hasAFanoutEdge(m.num).other) + " ");
					}
				}
				if (dealout == true) {
					System.out.print("NONE");
				}
				dealout = true;
				System.out.println("");
				System.out.print(g.io.getRealName(n.num) + " FanIns: ");
				for (Node m : g.nodes) {
					if (n.num != m.num && n.hasAFaninEdge(m.num) != null) {
						dealin = false;
						System.out.print(" " + g.io.getRealName(n.hasAFaninEdge(m.num).other));
					}
				}
				if (dealin == true) {
					System.out.print(" NONE");
				}
				dealin = true;
				System.out.println("");
			}

		}






		
	}
	

}
