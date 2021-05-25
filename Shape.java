// Roufos Dimitrios, 5090

public abstract class Shape
{
  private int area;

  public Shape(int area){
    this.area = area;
  }

  public int getArea(){
    return area;
  }

  public abstract double computeArea();

  public abstract String getType();

  public boolean sameArea(Shape other){
    if (area == other.getArea()){
      return true;
    }else{
      return false;
    }
  }

  public boolean sameType(Shape other){
    if (getType().equals(getType())){
      return true;
    }else{
      return false;
    }
  }

  public String toString(){
    return "Type: "+getType()+"\nArea: "+area;
  }
}
