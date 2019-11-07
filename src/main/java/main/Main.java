package main;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    System.out.println("Jee! Nyt ratkaistaan labyrintti!");

    tiralabyra.Image image = new tiralabyra.Image("/Users/windy/Pictures/labyrintti.png");
    tiralabyra.ConnectedGraph graph = new tiralabyra.ConnectedGraph(image.getNumberOfPixels());
    
    int entryNodeIndex = -1;
    int exitNodeIndex = -1;
    
    // Asetetaan valkoisille solmuille naapuruustieto nelinaapuruuden perusteella
    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        
        if (image.isTraversableAt(x, y)) {
          if (image.isTraversableAt(x + 1, y)) {
            graph.addNeighborhood(image.getIndexForPixel(x, y), 0,
                                  image.getIndexForPixel(x + 1, y));
            graph.addNeighborhood(image.getIndexForPixel(x + 1, y), 2,
                                  image.getIndexForPixel(x, y));
          }
          if (image.isTraversableAt(x, y + 1)) {
            graph.addNeighborhood(image.getIndexForPixel(x, y), 1,
                                  image.getIndexForPixel(x, y + 1));
            graph.addNeighborhood(image.getIndexForPixel(x, y + 1), 3,
                                  image.getIndexForPixel(x, y));

          }
        }
        
        if (image.hasEntryPointAt(x, y)) {
          entryNodeIndex = image.getIndexForPixel(x, y);
        }
        if (image.hasExitPointAt(x, y)) {
          exitNodeIndex = image.getIndexForPixel(x, y);
        }
      }
    }
    
    if (entryNodeIndex == -1) {
      System.out.println("Labyrinth has no entry point!");
      return;
    }
    if (exitNodeIndex == -1) {
      System.out.println("Labyrinth has no exit point!");
      return;
    }
    
    // Nyt meillä on verkko, käydään se läpi
    Queue<Integer> nodeQueue = new LinkedList<Integer>();
    nodeQueue.add(new Integer(entryNodeIndex));
    
    while (nodeQueue.size() > 0) {
      
    }
  }
}
