import java.util.List;
import java.util.ArrayList;
/**
 * A vertex in a graph
 * @param <T>
 */
class Vertex<T> {
  private List<Edge<T>> incomingEdges;

  private List<Edge<T>> outgoingEdges;

  private boolean mark;

  public String name;
  
  public String type;
  
  public T data;

  public T source;
  
  public T authority;
  
  public T trust;
  
  public T rating;

  /**
   * Calls this(null, null).
   */
  public Vertex() {
    this(null,null,null, null,null,null,null);
  }

  /**
   * Create a vertex with the given name and no data
   * 
   * @param n
   */
  public Vertex(String n,String t, T d) {
    this(n, t,d,null,null,null,null);
  }

  /**
   * Create a Vertex with name n and given data
   * 
   * @param n -
   *          name of vertex
   * @param source -
   *          source associated with vertex
   * @param authority -
   *          authority associated with vertex
   * @param trust -
   *          trust associated with vertex        
   */
  public Vertex(String n, String t,T data,T source, T authority, T trust, T rating) {
    incomingEdges = new ArrayList<Edge<T>>();
    outgoingEdges = new ArrayList<Edge<T>>();
    name = n;
    type = t;
    this.data = data;
    this.source = source;
    this.authority = authority;
    this.trust = trust;
    this.rating = rating;
  }

  /**
   * @return the possibly null name of the vertex
   */
  public String getName() {
    return name;
  }

  /**
   * @return the data of the vertex
   */
  public T getData() {
    return this.data;
  }

  
  /**
   * @return the source of the vertex
   */
  public T getSource() {
    return this.source;
  }

  /**
   * @param source
   *          The source to set.
   */
  public void setSource(T source) {
    this.source = source;
  }
  
  /**
   * @return the authority of the vertex
   */
  public T getAuthority() {
    return this.authority;
  }

  /**
   * @param authority
   *          The authority to set.
   */
  public void setAuthority(T authority) {
    this.authority = authority;
  }
  
  /**
   * @return the trust of the vertex
   */
  public T getTrust() {
    return this.trust;
  }

  /**
   * @param trust
   *          The trust to set.
   */
  public void setTrust(T trust) {
    this.trust = trust;
  }
  
  /**
   * @return the rating of the vertex
   */
  public T getRating() {
    return this.rating;
  }

  /**
   * @param rating
   *          The rating to set.
   */
  public void setRating(T rating) {
    this.rating = rating;
  }

  /**
   * Add an edge to the vertex. If edge.from is this vertex, its an outgoing
   * edge. If edge.to is this vertex, its an incoming edge. If neither from or
   * to is this vertex, the edge is not added.
   * 
   * @param e -
   *          the edge to add
   * @return true if the edge was added, false otherwise
   */
  public boolean addEdge(Edge<T> e) {
    if (e.getFrom() == this)
      outgoingEdges.add(e);
    else if (e.getTo() == this)
      incomingEdges.add(e);
    else
      return false;
    return true;
  }

  /**
   * Search the outgoing edges looking for an edge whose's edge.to == dest.
   * 
   * @param dest
   *          the destination
   * @return the outgoing edge going to dest if one exists, null otherwise.
   */
  public Edge<T> findEdge(Vertex<T> dest) {
    for (Edge<T> e : outgoingEdges) {
      if (e.getTo() == dest)
        return e;
    }
    return null;
  }
  
  /**
   * 
   * @return the count of incoming edges
   */
  public int getOutgoingEdgeCount() {
    return outgoingEdges.size();
  }

  /**
   * Get the ith outgoing edge
   * 
   * @param i
   *          the index into outgoing edges
   * @return ith outgoing edge
   */
  public Edge<T> getOutgoingEdge(int i) {
    return outgoingEdges.get(i);
  }

  /**
   * Get the outgoing edges
   * 
   * @return outgoing edge list
   */
  public List<Edge<T>> getOutgoingEdges() {
    return this.outgoingEdges;
  }
  
  /**
   * Set the vertex mark flag.
   * 
   */
  public void mark() {
    mark = true;
  }

  /**
   * Has this vertex been marked during a visit
   * 
   * @return true is visit has been called
   */
  public boolean visited() {
    return mark;
  }

  /**
   * Visit the vertex and set the mark flag to true.
   * 
   */
  public void visit() {
    mark();
  }

  
  /**
   * @return a string form of the vertex with in and out edges.
   */
  public String toString() {
    StringBuffer tmp = new StringBuffer("Vertex(");
    tmp.append(name);
    tmp.append(", type=");
    tmp.append(type);
    tmp.append(", data=");
    tmp.append(data);
    tmp.append(", source=");
    tmp.append(source);
    tmp.append(",authority=");
    tmp.append(authority);
    tmp.append(",trust=");
    tmp.append(trust);
    tmp.append(",rating=");
    tmp.append(rating);
    tmp.append("), in:[");
    for (int i = 0; i < incomingEdges.size(); i++) {
      Edge<T> e = incomingEdges.get(i);
      if (i > 0)
        tmp.append(',');
      tmp.append('{');
      tmp.append(e.getFrom().name);
      tmp.append(',');
      tmp.append(e.getCost());
      tmp.append('}');
    }
    tmp.append("], out:[");
    for (int i = 0; i < outgoingEdges.size(); i++) {
      Edge<T> e = outgoingEdges.get(i);
      if (i > 0)
        tmp.append(',');
      tmp.append('{');
      tmp.append(e.getTo().name);
      tmp.append(',');
      tmp.append(e.getCost());
      tmp.append('}');
    }
    tmp.append(']');
    return tmp.toString();
  }
}