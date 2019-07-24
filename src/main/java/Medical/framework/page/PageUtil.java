package Medical.framework.page;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Medical.framework.Util.StringUtils;
import Medical.framework.domain.BaseEntity;




import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class PageUtil {

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public static void startPage(Integer pageNum,Integer pageSize,String orderBy)
    {
    	PageHelper.startPage(pageNum, pageSize, orderBy);
    }

    public static void startPage(BaseEntity entity)
    {
        String orderBy = StringUtils.isEmpty(entity.getOrderByColumn())?"":(StringUtils.toUnderScoreCase(entity.getOrderByColumn()) + " " + entity.getIsAsc());
        PageHelper.orderBy(orderBy);
        if(StringUtils.isNotNull(entity.getPageNum()) && StringUtils.isNotNull(entity.getPageNum())){
            PageHelper.startPage(entity.getPageNum(),entity.getPageSize());
        }
    }
}