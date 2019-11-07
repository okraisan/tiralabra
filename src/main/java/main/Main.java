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
      System.out.println("Labyrinth has no entry point. Please color one pixel as #FF0000.");
      return;
    }
    if (exitNodeIndex == -1) {
      System.out.println("Labyrinth has no exit point. Please color one pixel as #00FF00.");
      return;
    }
    
    // Nyt meillä on verkko, käydään se läpi
    Queue<Integer> fillQueue = new LinkedList<Integer>();
    fillQueue.add(new Integer(entryNodeIndex));
    
    while (fillQueue.size() > 0) {
      int nodeIndex = fillQueue.remove();
      if (nodeIndex == exitNodeIndex) {
        return;
      }
      
      image.setPixelAtIndex(nodeIndex, 0x00FFFF);
      
      int[] neighbors = graph.getNodeAt(nodeIndex).getNeighbors();
      for (int i = 0; i < neighbors.length; i++) {
        if (neighbors[i] != -1) {
          fillQueue.add(neighbors[i]);
        }
      }
    }
    
    image.save("/tmp/out.png");
  }
}
