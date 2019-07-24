package Start;

public   class SynDemo {

  static  SynDemo synDemo=new SynDemo();

  public int get() throws InterruptedException {
    synchronized (synDemo) {
      Thread.sleep(9000);
      System.out.println(Thread.currentThread().getName());

      return 1;
    }
  }


}
