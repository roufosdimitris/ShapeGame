// Roufos Dimitrios, 5090

import java.lang.Math.*;

public class Circle extends Shape
{
  public Circle(int area){
    super(area);
  }

  public double computeArea(){
    return (double)getArea()*Math.PI/4;
  }

  public String getType(){
    return "Circle";
  }
}
