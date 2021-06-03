// Roufos Dimitrios, 5090

import java.util.*;

public class Player
{
  Stack<Shape> stack;
  private int stackSize;
  private double points;
  Scanner input;

  public Player(int stackSize){
    stack = new Stack<Shape>();
    this.stack = stack;
    this.stackSize = stackSize;

    input = new Scanner(System.in);
  }

  public void playShape(Shape shape){
    String accept = "";
    System.out.println("Incoming shape "+shape);
    System.out.println("Do you want to accept? (y/n)");
    accept = input.nextLine();

    while (true){
      if (!(accept.equals("y")) && !(accept.equals("n"))){
        System.out.println("Invalid input. Type y/n");
        accept = input.nextLine();
      }else{
        //System.out.println("while loop works");
        break;
      }
    }
    if ((accept.equals("y")) && (stack.size() > 0)){

      if (shape.sameArea(stack.peek())){
        System.out.println("10x points!");
        points += shape.computeArea()*10;
        System.out.println("Added "+shape.computeArea()*10+" points");
      }else{
        points += shape.computeArea();
        System.out.println("Added "+shape.computeArea()+" points");
      }
      if (shape.sameType(stack.peek())){
        stack.pop();
        System.out.println("Top shapes removed");
      }else{
        stack.push(shape);
      }
    }else if (accept.equals("y")){
      stack.push(shape);
      points += shape.computeArea();
      System.out.println("Added "+shape.computeArea()+" points");
    }
  }

  public boolean isStackFull(){
    if (stack.size() < stackSize){
      return false;
    }else{
      return true;
    }
  }

  public void printStack(){
    if (stack.size() == 0){

    }else{
      System.out.println("Current stack:");
      for (int i = stack.size()-1; i >= 0; i--){
        System.out.println("     "+(i+1)+":"+stack.get(i));
      }
    }
  }

  public double getPoints(){
    return points;
  }

  public static void main(String[] args){
    ShapeGenerator gen = new ShapeGenerator(25);
    Player p = new Player(10);
    for (int i = 0; i < 3; i++){
      p.playShape(gen.nextShape());
      System.exit(0);
    }
  }
}
