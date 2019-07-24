package Start.WebService;
import javax.xml.ws.Endpoint;

public class pubSpeak {

  public static void main(String[] args) {

    String address="http://localhost:7777/webService";
    Endpoint.publish(address,new SpeakDemoImpl());
    System.out.println("已发布");
  }
}
