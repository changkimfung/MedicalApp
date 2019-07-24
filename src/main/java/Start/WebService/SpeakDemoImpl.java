package Start.WebService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SpeakDemoImpl implements SpeakDemo {

  @WebMethod
  @Override
  public void Speak() {
    System.out.println("Hello Jeffrey! I'm webservicedemo");
  }
}
