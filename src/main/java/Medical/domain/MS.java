package Medical.domain;

import Medical.framework.domain.BaseEntity;

import java.io.Serializable;

public class MS implements Serializable {

    private  String id;
    private  String phone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
