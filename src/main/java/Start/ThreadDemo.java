package Start;

public class ThreadDemo implements Runnable {

  private String name;

  @Override
  public void run() {
    System.out.println(12131313);
    try {
      System.out.println(new SynDemo().get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public ThreadDemo(String name) {
    this.name = name;
  }




  }

