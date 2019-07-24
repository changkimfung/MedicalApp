package Medical.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NumMapper {
  public int deleteNum();
  public int find();
}
