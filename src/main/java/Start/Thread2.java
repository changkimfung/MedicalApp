package Start;

public class Thread2  implements  Runnable{

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(222222);
    try {
      System.out.println(new SynDemo().get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
