package tiralabyra;

/**
 * A graph of nodes connected by edges.
 */
public class ConnectedGraph {

  private Edge[][] edges;
  private double[] euclideanDistancesToExit;

  private int entryNodeIndex = -1;
  private int exitNodeIndex = -1;

  /**
   * Maximum number of neighbors a node can have.
   */
  private final int numberOfNeighborhoods = 8;

  public ConnectedGraph() {
  }

  /**
   * Build a connected graph based on an input image, with all neighborhoods
   * and input/exit nodes in place.
   * @param image Input image with correctly color-labeled walls and entry/exit
   *     points.
   */
  public void build(Image image) {
    // Create blank Edge objects
    edges = new Edge[image.getNumberOfPixels()][numberOfNeighborhoods];
    for (int i = 0; i < image.getNumberOfPixels(); i++) {
      for (int j = 0; j < numberOfNeighborhoods; j++) {
        edges[i][j] = new Edge(-1, -1, 0.0);
      }
    }

    // Direction vectors, for clarity.
    final Point dE  = new Point(1,  0);
    final Point dSE = new Point(1,  1);
    final Point dS  = new Point(0,  1);
    final Point dSW = new Point(-1, 1);
    final Point dW  = new Point(-1, 0);

    // Neighborhood direction numbers
    final int dirNumE  = 0;
    final int dirNumSE = 1;
    final int dirNumS  = 2;
    final int dirNumSW = 3;

    Point exitPoint = new Point(0, 0);
    entryNodeIndex = -1;
    exitNodeIndex = -1;

    // Assign a neighborhood to all non-wall pixels.
    for (Point point : image.getPixelPositions()) {
      if (image.isTraversableAt(point)) {
        // System.out.println(point + " traversable");
        // Non-wall pixel to the East is always traversable.
        if (image.isTraversableAt(Point.add(point, dE))) {
          addEdge(image.getIndexForPixel(point),
                  image.getIndexForPixel(Point.add(point, dE)),
                  dirNumE, 1.0);
        }

        // Non-wall pixel to the South-East is traversable unless there's a
        // corner in between.
        if (image.isTraversableAt(Point.add(point, dSE))
            && image.isTraversableAt(Point.add(point, dS))
            && image.isTraversableAt(Point.add(point, dE))) {
          addEdge(image.getIndexForPixel(point),
                  image.getIndexForPixel(Point.add(point, dSE)),
                  dirNumSE, Math.sqrt(2.0));
        }

        // Non-wall pixel to the South is always traversable.
        if (image.isTraversableAt(Point.add(point, dS))) {
          addEdge(image.getIndexForPixel(point),
                  image.getIndexForPixel(Point.add(point, dS)),
                  dirNumS, 1.0);
        }

        // Non-wall pixel to the South-West is traversable unless there's a
        // corner in between.
        if (image.isTraversableAt(Point.add(point, dSW))
            && image.isTraversableAt(Point.add(point, dS))
            && image.isTraversableAt(Point.add(point, dW))) {
          addEdge(image.getIndexForPixel(point),
                  image.getIndexForPixel(Point.add(point, dSW)),
                  dirNumSW, Math.sqrt(2.0));
        }
      }

      // Assign entry and exit point.
      if (image.hasEntryPointAt(point)) {
        entryNodeIndex = image.getIndexForPixel(point);
      }
      if (image.hasExitPointAt(point)) {
        exitNodeIndex = image.getIndexForPixel(point);
        exitPoint = point;
      }

    }

    if (entryNodeIndex == -1) {
      System.out.println("Labyrinth has no entry point. Please color one "
                         + "pixel as #FF0000.");
      return;
    }
    if (exitNodeIndex == -1) {
      System.out.println("Labyrinth has no exit point. Please color one "
                         + "pixel as #00FF00.");
      return;
    }

    euclideanDistancesToExit = new double[image.getNumberOfPixels()];
    for (Point point : image.getPixelPositions()) {
      euclideanDistancesToExit[image.getIndexForPixel(point)] = point.distanceTo(exitPoint);
    }
  }

  /**
   * Add a bidirectional neighborhood for two nodes.
   * @param nodeIndex     Index of the originating node in the graph.
   * @param neighborIndex Index of the neighbor node in the graph.
   * @param direction     Direction of neighborhood (0-7); used as an inner index.
   * @param weight        Edge weight (cost).
   */
  public void addEdge(int nodeIndex, int neighborIndex,
                      int direction, double weight) {
    if (nodeIndex >= 0 && nodeIndex < edges.length
        && neighborIndex >= 0 && neighborIndex < edges.length
        && direction >= 0 && direction < numberOfNeighborhoods) {
      edges[nodeIndex][direction] =
          new Edge(nodeIndex, neighborIndex, weight);

      // Set the opposite direction as well.
      int otherDirection = (direction + numberOfNeighborhoods / 2)
                           % numberOfNeighborhoods;
      edges[neighborIndex][otherDirection] =
          new Edge(neighborIndex, nodeIndex, weight);
    }
  }

  public int getEntryNodeIndex() {
    return entryNodeIndex;
  }

  public int getExitNodeIndex() {
    return exitNodeIndex;
  }

  public int size() {
    return edges.length;
  }

  /**
   * Get all edges connected to a certain node.
   * @param nodeIndex Index of the requested origin node.
   * @return An array of edges.
   */
  public Edge[] getEdgesFrom(int nodeIndex) {
    return edges[nodeIndex];
  }

  public double getEuclideanDistanceToExit(int nodeIndex) {
    return euclideanDistancesToExit[nodeIndex];
  }
}
