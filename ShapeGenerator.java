// Roufos Dimitrios, 5090

import java.util.*;

public class ShapeGenerator
{
  private Shape[] arrayOfShapes;
  private boolean[] usedShapes;
  private Random random;
  private int[] possibleAreas = new int[]{1,2,3,4,8,12,16};

  public ShapeGenerator(int numberOfShapes){
    random = new Random();
    this.random = random;

    arrayOfShapes = new Shape[4*numberOfShapes];
    this.arrayOfShapes = arrayOfShapes;

    usedShapes = new boolean[4*numberOfShapes];
    this.usedShapes = usedShapes;

    initializeShapes(numberOfShapes);
  }

  private void initializeShapes(int numberOfShapes){
    for (int i = 0; i < (arrayOfShapes.length/4); i++){
      int x1 = random.nextInt(possibleAreas.length);
      int x2 = random.nextInt(possibleAreas.length);
      int x3 = random.nextInt(possibleAreas.length);
      int x4 = random.nextInt(possibleAreas.length);
      arrayOfShapes[i] = new Square(possibleAreas[x1]);
      arrayOfShapes[i+numberOfShapes] = new Triangle(possibleAreas[x2]);
      arrayOfShapes[i+2*numberOfShapes] = new Pentagon(possibleAreas[x3]);
      arrayOfShapes[i+3*numberOfShapes] = new Circle(possibleAreas[x4]);
    }
    // the same method for shuffling from assignment1 with some changes to work for object array
    for (int i = arrayOfShapes.length - 1; i >= 0; i --){
      int index = random.nextInt(i + 1);
      Shape temp = arrayOfShapes[index];
      arrayOfShapes[index] = arrayOfShapes[i];
      arrayOfShapes[i] = temp;
    }
  }

  public Shape nextShape(){
    int var = random.nextInt(arrayOfShapes.length);
    while (true){
      if (usedShapes[var] == true){
        var = random.nextInt(arrayOfShapes.length);
      }else{
        break;
      }
    }
    usedShapes[var] = true;
    return arrayOfShapes[var];
  }

  public boolean hasShape(){
    for (int i = 0; i < usedShapes.length; i++){
      if (usedShapes[i]){
        return false;
      }else{
        continue;
      }
    }
    return true;
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < arrayOfShapes.length; i++){
      if (usedShapes[i] == false){
        str += i+" "+arrayOfShapes[i]+"\n";
      }else{
        continue;
      }
    }
    return str;
  }

  public static void main(String[] args) {
    ShapeGenerator gen = new ShapeGenerator(2);
    for (int i = 0; i < gen.arrayOfShapes.length; i++){
      System.out.println(gen.arrayOfShapes[i]);
    }
    System.out.println("\nLeft shapes:\n"+gen);
    System.out.println("\n\n");
    for (int i = 0; i < 8; i++){
      System.out.println(gen.nextShape());
      System.out.println("\nLeft shapes:\n"+gen);
    }
  }
}
