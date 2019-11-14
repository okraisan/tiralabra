package tiralabyra;

public class ConnectedGraph {
  Node[] nodes;

  /**
   * Which node is the entry point.
   */
  private int entryNodeIndex = -1;

  /**
   * Which node is the exit point.
   */
  private int exitNodeIndex = -1;

  public ConnectedGraph(final int size) {
    nodes = new Node[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new Node();
    }
  }

  /**
   * Build a connected graph based on an input image, with all neighborhoods
   * and input/exit nodes in place.
   * @param image Input image with correctly color-labeled walls and entry/exit
   * points.
   */
  public ConnectedGraph(final Image image) {

    // Direction vectors, for better clarity.
    final Point dE  = new Point(1,  0);
    final Point dSE = new Point(1,  1);
    final Point dS  = new Point(0,  1);
    final Point dSW = new Point(-1, 1);
    final Point dW  = new Point(-1, 0);

    // Assign a neighborhood to all non-wall pixels.
    for (Point point : image.getPixelPositions()) {
      if (image.isTraversableAt(point)) {
        // Non-wall pixel to the East is always traversable.
        if (image.isTraversableAt(Point.add(point, dE))) {
          addNeighborhood(image.getIndexForPixel(point),
                          image.getIndexForPixel(Point.add(point, dE)));
        }

        // Non-wall pixel to the South is always traversable.
        if (image.isTraversableAt(Point.add(point, dS))) {
          addNeighborhood(image.getIndexForPixel(point),
                          image.getIndexForPixel(Point.add(point, dS)));
        }

        // South-west pixel is traversable unless there's a corner in between.
        if (image.isTraversableAt(Point.add(point, dSW))
            && image.isTraversableAt(Point.add(point, dW))
            && image.isTraversableAt(Point.add(point, dE))) {
          addNeighborhood(image.getIndexForPixel(point),
                          image.getIndexForPixel(Point.add(point, dSW)));
        }

        // South-east pixel is traversable unless there's a corner in between.
        if (image.isTraversableAt(Point.add(point, dSE))
            && image.isTraversableAt(Point.add(point, dS))
            && image.isTraversableAt(Point.add(point, dE))) {
          addNeighborhood(image.getIndexForPixel(point),
                          image.getIndexForPixel(Point.add(point, dSE)));
        }
      }

      if (image.hasEntryPointAt(point)) {
        entryNodeIndex = image.getIndexForPixel(point);
      }
      if (image.hasExitPointAt(point)) {
        exitNodeIndex = image.getIndexForPixel(point);
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

  }

  /**
   * Adds a bidirectional neighborhood for two nodes.
   * @param nodeIndex     Index of the originating node in the graph.
   * @param neighborIndex Index of the neighbor node in the graph.
   */
  public void addNeighborhood(final int nodeIndex, final int neighborIndex) {
    if (nodeIndex >= 0 && nodeIndex < nodes.length
        && neighborIndex >= 0 && neighborIndex < nodes.length) {
      nodes[nodeIndex].addNeighbor(neighborIndex);
      nodes[neighborIndex].addNeighbor(nodeIndex);
    }
  }

  public Node getNodeAt(final int nodeIndex) {
    // TODO: What happens when out of bounds?
    return nodes[nodeIndex];
  }
}
