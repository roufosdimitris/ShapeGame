// Roufos Dimitrios, 5090

public class Pentagon extends Shape
{
  public Pentagon(int area){
    super(area);
  }

  public double computeArea(){
    return (double)(getArea()*3)/4;
  }

  public String getType(){
    return "Pentagon";
  }
}
