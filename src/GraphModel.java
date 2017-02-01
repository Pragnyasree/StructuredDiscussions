/**
   Graph model class for testing
   Version 1.0
*/

public class GraphModel
{
	static Vertex<String> S1,S2,C1,C2,C3,C4,E1,E2,E3,E4 ;
	public static void main(String[] a)
	{
	  Graph<String> graph = new Graph<String>();
	  
	  //creating vertices with their attributes
	  
	  S1 = new Vertex<String>("S1","Stance","Yes");
	  
	  C1 = new Vertex<String>("C1","Claim","Java is great for web development");
	  
	  E1 = new Vertex<String>("E1","Evidence","Java can be used in servlet containers and JSP");
	  E1.setSource("Java Wikipedia page");
	  
	  E2 = new Vertex<String>("E2","Evidence","Java is used in Hadoop and distributed file systems");
	  E2.setSource("Apache Hadoop Page");

      C2 = new Vertex<String>("C2","Claim","Java is great for writing applications");
    
      E3 = new Vertex<String>("E3","Evidence","Java is used in writing academic applications");
	  E3.setSource("Some website showing this");
  
      S2 = new Vertex<String>("S2","Stance","No");
      
	  C3 = new Vertex<String>("C3","Claim","Java is very slow");
	  
	  E4 = new Vertex<String>("E4","Evidence","Java is an interpreted language and is very slow");
	  E4.setSource("Horstmann Java Textbook");

	  C4 = new Vertex<String>("C4","Claim","Java requires too much scaffolding for writing programs");
	  C4.setSource("Lewis Java Textbook");
	  	  
	  //adding all the vertices to the graph
	  
	  graph.addVertex(S1);
	  graph.addVertex(S2);
	  graph.addVertex(C1);
	  graph.addVertex(C2);
	  graph.addVertex(C3);
	  graph.addVertex(C4);
	  graph.addVertex(E1);
	  graph.addVertex(E2);
	  graph.addVertex(E3);
	  graph.addVertex(E4);
	  
	  //displaying number of vertices in graph
	  
	  System.out.println("The number of vertices in graph is:" + graph.verticessize());
	  
	  //adding edges betweeen vertices
	  
	  graph.addEdge(S1, C1,0);
	  graph.addEdge(C1, E1,0);
	  graph.addEdge(C1, E2,0);
	  graph.addEdge(S1, C2,0);
	  graph.addEdge(C2, E3,0);
	  graph.addEdge(S2, C3,0);
	  graph.addEdge(C3, E4,0);
	  graph.addEdge(S2, C4,0);
	  
      //displaying number of edges in graph
	  
	  System.out.println("The number of edges in graph is:" + graph.edgessize());
	  System.out.println("The information about edges");
	  System.out.println(graph.getEdges());
	  
	  //displaying all the information about vertices of graph
	  
	  System.out.println("The information about vertices with attributes:");
	  String stance1 = S1.toString();
	  System.out.println(stance1);
	  String claim1 = C1.toString();
	  System.out.println(claim1);
	  String evidence1 = E1.toString();
	  System.out.println(evidence1);
	  String evidence2 = E2.toString();
	  System.out.println(evidence2);
	  String claim2 = C2.toString();
	  System.out.println(claim2);
	  String evidence3 = E3.toString();
	  System.out.println(evidence3);
	  String stance2 = S2.toString();
	  System.out.println(stance2);
	  String claim3 = C3.toString();
	  System.out.println(claim3);
	  String evidence4 = E4.toString();
	  System.out.println(evidence4);
	  String claim4 = C4.toString();
	  System.out.println(claim4);
	  
	  
	  
	}
}