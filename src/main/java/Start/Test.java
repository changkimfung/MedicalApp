package Start;

public class Test {
  public static void main(String[] args) {
    ThreadDemo a = new ThreadDemo("123");
    Thread2 as=new Thread2();


    Thread t1 = new Thread(a);

    Thread t2 = new Thread(as);
      t1.start();

      t2.start();


  }
}
