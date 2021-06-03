// Roufos Dimitrios, 5090

import java.util.*;

public class ShapeGame
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("\nWelcome to Shape Game!\n");

    int numShape;
    System.out.println("Give the number of shapes per type:");
    numShape = scan.nextInt();

    int stckSize;
    System.out.println("Give the size of the stack for the player:");
    stckSize = scan.nextInt();

    scan.nextLine();
    ShapeGenerator generator = new ShapeGenerator(numShape);
    Player player = new Player(stckSize);
    System.out.println("\n");

    while (true){
      if (player.isStackFull()){
        System.out.println("Stack is full\nGAME OVER!");
        break;
      }
      if (!generator.hasShape()){
        System.out.println("YOU WIN!");
        break;
      }

      player.printStack();
      System.out.println("\n");
      player.playShape(generator.nextShape());
      System.out.println("Points: "+player.getPoints()+"\n");
    }
  }
}
