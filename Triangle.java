// Roufos Dimitrios, 5090

public class Triangle extends Shape
{
  public Triangle(int area){
    super(area);
  }

  public double computeArea(){
    return (double)getArea()/2;
  }

  public String getType(){
    return "Triangle";
  }
}
