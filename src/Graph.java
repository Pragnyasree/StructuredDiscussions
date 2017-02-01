
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A directed graph data structure.
 * @param <T>
 */

public class Graph<T> {

  /** Vector<Vertex> of graph verticies */
  private List<Vertex<T>> verticies;

  /** Vector<Edge> of edges in the graph */
  private List<Edge<T>> edges;

  /** The vertex identified as the root of the graph */
  private Vertex<T> rootVertex;

  /**
   * Construct a new graph without any vertices or edges
   */
  public Graph() {
    verticies = new ArrayList<Vertex<T>>();
    edges = new ArrayList<Edge<T>>();
  }

  /**
   * Are there any verticies in the graph
   * 
   * @return true if there are no verticies in the graph
   */
  public boolean isEmpty() {
    return verticies.size() == 0;
  }

  /**
   * Add a vertex to the graph
   * 
   * @param v
   *          the Vertex to add
   * @return true if the vertex was added, false if it was already in the graph.
   */
  public boolean addVertex(Vertex<T> v) {
    boolean added = false;
    if (verticies.contains(v) == false) {
      added = verticies.add(v);
    }
    return added;
  }

  /**
   * Get the vertex count.
   * 
   * @return the number of verticies in the graph.
   */
  public int verticessize() {
    return verticies.size();
  }
  
  /**
   * Get the edges count.
   * 
   * @return the number of edges in the graph.
   */
  public int edgessize() {
    return edges.size();
  }

  /**
   * Get the root vertex
   * 
   * @return the root vertex if one is set, null if no vertex has been set as
   *         the root.
   */
  public Vertex<T> getRootVertex() {
    return rootVertex;
  }

  /**
   * Set a root vertex. If root does no exist in the graph it is added.
   * 
   * @param root -
   *          the vertex to set as the root and optionally add if it does not
   *          exist in the graph.
   */
  public void setRootVertex(Vertex<T> root) {
    this.rootVertex = root;
    if (verticies.contains(root) == false)
      this.addVertex(root);
  }

  /**
   * Get the given Vertex.
   * 
   * @param n
   *          the index [0, size()-1] of the Vertex to access
   * @return the nth Vertex
   */
  public Vertex<T> getVertex(int n) {
    return verticies.get(n);
  }

  /**
   * Get the graph verticies
   * 
   * @return the graph verticies
   */
  public List<Vertex<T>> getVerticies() {
    return this.verticies;
  }

  /**
   * Insert a directed, weighted Edge<T> into the graph.
   * 
   * @param from -
   *          the Edge<T> starting vertex
   * @param to -
   *          the Edge<T> ending vertex
   * @param cost -
   *          the Edge<T> weight/cost
   * @return true if the Edge<T> was added, false if from already has this Edge<T>
   * @throws IllegalArgumentException
   *           if from/to are not verticies in the graph
   */
  public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost) throws IllegalArgumentException {
    if (verticies.contains(from) == false)
      throw new IllegalArgumentException("from is not in graph");
    if (verticies.contains(to) == false)
      throw new IllegalArgumentException("to is not in graph");

    Edge<T> e = new Edge<T>(from, to, cost);
    if (from.findEdge(to) != null)
      return false;
    else {
      from.addEdge(e);
      to.addEdge(e);
      edges.add(e);
      return true;
    }
  }


  /**
   * Get the graph edges
   * 
   * @return the graph edges
   */
  public List<Edge<T>> getEdges() {
    return this.edges;
  }

  /**
   * Search the verticies for one with name.
   * 
   * @param name -
   *          the vertex name
   * @return the first vertex with a matching name, null if no matches are found
   */
  public Vertex<T> findVertexByName(String name) {
    Vertex<T> match = null;
    for (Vertex<T> v : verticies) {
      if (name.equals(v.getName())) {
        match = v;
        break;
      }
    }
    return match;
  }

  /**
   * Search the verticies for one with rating.
   * 
   * @param rating -
   *          the vertex rating to match
   * @param compare -
   *          the comparator to perform the match
   * @return the first vertex with a matching rating, null if no matches are found
   */
  public Vertex<T> findVertexByRating(T rating, Comparator<T> compare) {
    Vertex<T> match = null;
    for (Vertex<T> v : verticies) {
      if (compare.compare(rating, v.getRating()) == 0) {
        match = v;
        break;
      }
    }
    return match;
  }
  
  
}

