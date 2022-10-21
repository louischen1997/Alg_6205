import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * File Name: GraphBuilder.java
 * 
 */

class GraphBuilder {
	private Graph g;
	private int count=0;
	

	GraphBuilder(Graph g, String f) {
		this.g = g;
		buildGraph(f);
	}

	private void buildGraph(String f) {
		System.out.println("Building Graph from file " + f);
		int numlines = 0;
		GraphType.Type t = g.type;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			StringBuilder sb = new StringBuilder();
			String lastline = null;
			int notreadlines = 0;
			while (true) {
				String line1 = br.readLine();
				if (line1 == null) {
					//System.out.println("lastline = " + lastline) ;
					//System.out.println("notreadlines = " + notreadlines) ;

					break;
				} else {
					// 956468   9 0.00202841
					//Eat both leading and trailing spaces using trim
					String line = line1.trim();
					//There may be more than one space
					//956468   9 0.00202841
					lastline = line;
					String delims = "[ ]+";
					String[] s = line.split(delims);
					int l = s.length;
					if (l == 3) {
						++numlines;
						g.u.myassert((t == GraphType.Type.WEIGHTED_UNDIRECTED) || (t == GraphType.Type.WEIGHTED_DIRECTED));
					} else if (l == 2) {
						++numlines;
						g.u.myassert((t == GraphType.Type.UNDIRECTED) || (t == GraphType.Type.DIRECTED));
					} else {
						//System.out.println("l = " + l + " line = " + line) ;
						++notreadlines;
					}

				

					if(!s[0].equals("") || !s[1].equals("") ) {

						if (g.io.graphHasANode(s[0]) == -1) {
							g.io.insertOrFind(s[0], false);
							g.buildNodeIfNotExistAndAppend(count);
							g.io.insertOrFind(s[0], false);
							count++;
						}

						if (g.io.graphHasANode(s[1]) == -1) {
							g.io.insertOrFind(s[1], false);
							g.buildNodeIfNotExistAndAppend(count);
							count++;
						}

						if (!s[0].equals(s[1])) {
							if ((t == GraphType.Type.WEIGHTED_UNDIRECTED) || (t == GraphType.Type.WEIGHTED_DIRECTED)) {
								double d1 = Double.valueOf(s[2]);
								if ((t == GraphType.Type.WEIGHTED_UNDIRECTED)) {
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), d1, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), d1, false);

									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), d1, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), d1, false);

								} else {
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), d1, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), d1, false);
								}

							}
						}

						if (s[0] != s[1]) {
							if ((t == GraphType.Type.UNDIRECTED) || (t == GraphType.Type.DIRECTED)) {
								if ((t == GraphType.Type.UNDIRECTED)) {
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), 0, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), 0, false);

									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), 0, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), 0, false);

								} else {
									g.createEdge(g.getNode(g.io.insertOrFind(s[0], true)), g.getNode(g.io.insertOrFind(s[1], true)), 0, true);
									g.createEdge(g.getNode(g.io.insertOrFind(s[1], true)), g.getNode(g.io.insertOrFind(s[0], true)), 0, false);
								}
							}
						}


					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
