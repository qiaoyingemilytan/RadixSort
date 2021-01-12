public class Radix{
  public static int nth(int n, int col){
    return (int) (n % Math.pow(10, (col+1)) / Math.pow(10, col));
  }
}
