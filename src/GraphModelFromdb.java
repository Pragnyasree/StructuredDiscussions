//Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GraphModelFromdb {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/structureddiscussion";

   //  Database credentials
   static final String USER = "dataadmin";
   static final String PASS = "sd_database1";
   
   //To create graph object
   static Graph<String> graph = new Graph<String>();
   
   //To create vertex , edge objects
   static ArrayList<Vertex<String>> vertexArrLst = new ArrayList<Vertex<String>>();
   static ArrayList<Edge<String>> edgArrLst = new ArrayList<Edge<String>>();
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   Statement stmt2 = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      stmt2 = conn.createStatement();
      String sql , sql2;
      sql = "SELECT * FROM vertex";
      sql2 = "SELECT * FROM edge";
      ResultSet rs = stmt.executeQuery(sql);
      ResultSet rs2 = stmt2.executeQuery(sql2);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("vertex_id");
         String type  = rs.getString("vertex_type");
         String data = rs.getString("vertex_data");
         String source  = rs.getString("vertex_source");
         String authority = rs.getString("vertex_authority");
         String trust = rs.getString("vertex_trust");
         String rating = rs.getString("vertex_rating");
         //add information to each vertex object
         vertexArrLst.add(new Vertex<String>(id,type,data,source,authority,trust,rating));   
      }
      
      //add each vertex to graph
      Iterator<Vertex<String>>  iterator = vertexArrLst.iterator();
		while (iterator.hasNext()) {
			graph.addVertex(iterator.next());
		}
		
		while(rs2.next()){
	         //Retrieve by column name
	         String from  = rs2.getString("edge_from");
	         Object from1 = from ;
	         Vertex<String> v1  = (Vertex<String>) from1;
	         String to  = rs2.getString("edge_to");
	         Object to1 = to ;
	         Vertex<String> v2  = (Vertex<String>) to1;
	         int cost = rs.getInt("cost");
	         //add information to each vertex object
	         edgArrLst.add(new Edge(v1,v2,cost)); 
	         graph.addEdge(v1, v2, cost);
	      }
	      
	  //To display vertices information	
	  System.out.print("The number of vertices in graph :");
	  System.out.print(graph.verticessize());
	  System.out.println("The vertices information is :");
	  System.out.println(graph.getVerticies()) ;
	  System.out.println("The edges information is :");
	  System.out.println(graph.getEdges()) ;
	  
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Done!");
}//end main
}//end FirstExample
