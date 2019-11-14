package tiralabyra;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    
    final int backtrackColor = 0xFFFF0000;
    final String inFileName  = "C:\\Users\\windy\\Pictures\\labyrintti.png";
    final String outFileName = "C:\\Users\\windy\\Pictures\\labyra_out.png";

    Image image = new tiralabyra.Image(inFileName);
    ConnectedGraph graph = new tiralabyra.ConnectedGraph(image.getNumberOfPixels());
    
    int entryNodeIndex = -1;
    int exitNodeIndex  = -1;
    
    Point  E = new Point(1,  0);
    Point SE = new Point(1,  1);
    Point S  = new Point(0,  1);
    Point SW = new Point(-1, 1);
    Point  W = new Point(-1, 0);
    
    // Assign a neighborhood to all non-wall pixels.
    for (Point point : image.getPixelPositions()) {
      if (image.isTraversableAt(point)) {
        // Non-wall pixel to the East is always traversable.
        if (image.isTraversableAt(Point.add(point, E))) {
          graph.addNeighborhood(image.getIndexForPixel(point),
                                image.getIndexForPixel(Point.add(point, E)));
        }
        
        // Non-wall pixel to the South is always traversable.
        if (image.isTraversableAt(Point.add(point, S))) {
          graph.addNeighborhood(image.getIndexForPixel(point),
                                image.getIndexForPixel(Point.add(point, S)));
        }
        
        // South-west pixel is traversable unless there's a corner in between.
        if (image.isTraversableAt(Point.add(point, SW))
            && image.isTraversableAt(Point.add(point,  W)) && image.isTraversableAt(Point.add(point, E))) {
          graph.addNeighborhood(image.getIndexForPixel(point),
                                image.getIndexForPixel(Point.add(point, SW)));
        }
        
        // South-east pixel is traversable unless there's a corner in between.
        if (image.isTraversableAt(Point.add(point, SE))
            && image.isTraversableAt(Point.add(point,  S)) && image.isTraversableAt(Point.add(point, E))) {
          graph.addNeighborhood(image.getIndexForPixel(point),
                                image.getIndexForPixel(Point.add(point, SE)));
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
      System.out.println("Labyrinth has no entry point. Please color one pixel as #FF0000 (" + 0xff000000 + ")");
      return;
    }
    if (exitNodeIndex == -1) {
      System.out.println("Labyrinth has no exit point. Please color one pixel as #00FF00.");
      return;
    }
    
    // Breadth-first search.
    boolean[] isVisited = new boolean[image.getNumberOfPixels()];
    int[]     parent    = new int[image.getNumberOfPixels()];
    
    Queue<Integer> fillQueue = new LinkedList<Integer>();
    fillQueue.add(new Integer(entryNodeIndex));

    while (fillQueue.size() > 0) {
      int nodeIndex = fillQueue.remove();
      if (nodeIndex == exitNodeIndex) {
        break;
      }

      for (int neighborIndex : graph.getNodeAt(nodeIndex).getNeighbors()) {
        if (neighborIndex != -1 && !isVisited[neighborIndex]) {
          isVisited[neighborIndex] = true;
          parent[neighborIndex] = nodeIndex;
          fillQueue.add(neighborIndex);
        }
      }
    }
    
    // Backtrack.
    int backtrackIndex = exitNodeIndex;
    while (backtrackIndex != entryNodeIndex) {
      image.plotPathAroundIndex(backtrackIndex, backtrackColor);
      backtrackIndex = parent[backtrackIndex];
    }
    
    image.save(outFileName);
  }
}
