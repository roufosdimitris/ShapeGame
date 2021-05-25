// Roufos Dimitrios, 5090

public class Square extends Shape
{
  public Square(int area){
    super(area);
  }

  public double computeArea(){
    return (double)getArea();
  }

  public String getType(){
    return "Square";
  }
}
