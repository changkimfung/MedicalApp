package Medical.domain;

import Medical.framework.domain.BaseEntity;

import java.io.Serializable;

public class Num implements Serializable {

  private String id;
  private  int num;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
