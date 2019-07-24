package Start.WebService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SpeakDemo {

  @WebMethod
  public void Speak();
}
