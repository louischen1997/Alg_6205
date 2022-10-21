import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

/**
 * File Name: GraphDFSUsingTimeStamp.java
 * 
 * 
 */

class GraphDFSUsingTimeStamp{
	private Graph g ;
	private int [] work ;
	private boolean [] cycle;
	private ArrayList<Integer> topologicalOrderArray;
	private String f;
	private int[][] steps;
	private int count=1;
	private HashMap<Integer, Integer> order ;



	
	
	GraphDFSUsingTimeStamp(Graph g, int [] work, boolean [] cycle,ArrayList<Integer> topologicalOrderArray,String f) {
		this.g = g ;
		this.work = work ;
		this.cycle = cycle ;
		this.topologicalOrderArray = topologicalOrderArray ;
		this.f = f ;
		//You MUST WRITE 2 routines 
		dfs() ;
		writeDFSDot() ;
	}
	
	

	private void dfs(){
		steps=new int [g.numV()][2];
		order = new HashMap<Integer,Integer>();
		for(Node n:g.nodes){
			work[0]++;
			if(steps[n.num][0]==0){
				implementdfs(n);
			}
		}

		for(int i= order.size();i>=1;i--){
			if (topologicalOrderArray.contains(order.get(i))){
				continue;
			}
			else{
				topologicalOrderArray.add(order.get(i));
			}
		}
		for(Node n:g.nodes){
		for(Node m:g.nodes){
			if(n.fanout.get(m.num)!=null){
				if(steps[n.num][0]-steps[m.num][0]>1 && steps[m.num][1]-steps[n.num][1]>1){
					cycle[0]=true;
					break;
					}
				}
			}
		}
	}

	private void implementdfs(Node n){

		if(steps[n.num][0]==0){
			steps[n.num][0]=count;
			order.put(count,n.num);
			count++;

			for(Node m:g.nodes){
				if(n.fanout.get(m.num)!=null){
					work[0]++;
					if(steps[m.num][0]==0 ){
					   	implementdfs(m);
					}
				}
			}
				steps[n.num][1]=count;
				order.put(count,n.num);
				count++;
		}
	}

	private void writeDFSDot(){

		if (false) {
			try {
				System.setOut(new PrintStream(new FileOutputStream(f)));
				System.out.println("digraph g {");
				System.out.print("label = \"[ ");
				for(int t:topologicalOrderArray){
					System.out.print(g.io.getRealName(t)+" ");
				}
				System.out.print("] ");
				if(cycle[0]==true){
					System.out.println("LOOP\"");
				}
				else{
					System.out.println("NOLOOP\"");
				}
				for(Node r:g.nodes){
					System.out.print(g.io.getRealName(r.num));
					System.out.print("[label = <"+g.io.getRealName(r.num)+"<BR />");
					System.out.print("<FONT POINT-SIZE=\"10\">");
					System.out.print(steps[r.num][0]+"/"+steps[r.num][1]);
					System.out.println("</FONT>>]");
				}

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


	} ;
	
}
