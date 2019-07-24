package Medical.mapper;

import Medical.domain.MS;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MsMapper {

  public int insertPhone(MS ms);
}
