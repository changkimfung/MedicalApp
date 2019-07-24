package Medical.controller;

import Medical.domain.InjuryHandle;
import Medical.framework.Util.StringUtils;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.InjuryHandleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *伤病申请证明控制器
 * @author zjf
 * @date 2019/01/14
 */

@Api("伤病证明业务")
@RequestMapping("/InjuryHandle")
@RestController
public class InjuryHandleController extends BaseController {


   @Autowired
    private InjuryHandleService  injuryHandleService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param injuryHandle
     * @return
     */

    @ApiOperation("伤病证明申请列表")
    @GetMapping("/list")
    public AjaxResult  list(Integer pageNum, Integer pageSize, InjuryHandle injuryHandle){
       injuryHandle.setPageNum(pageNum);
       injuryHandle.setPageSize(pageSize);
       TableDataInfo list   =injuryHandleService.selectInjuryHandleListPage(injuryHandle);
       return success("",list);
   }

    /**
     * 编辑
     * @param uid
     * @return
     */

    @ApiOperation("伤病证明编辑")
    @GetMapping("/edit/{uid}")
    public AjaxResult edit(@PathVariable("uid")String uid){
        InjuryHandle injuryHandle=injuryHandleService.selectInjuryHandleById(uid);
        return success("",injuryHandle);

    }

    /**
     * 删除
     * @param uid
     * @return
     */
    @ApiOperation("伤病证明申请删除")
    @PostMapping("/remove")
    public AjaxResult remove(String uid){

       String[] ids =null;
       if (StringUtils.isNotEmpty(uid)){
           ids=uid.split(",");
       }
       int rows=injuryHandleService.deleteInjuryHandleByIds(ids);
       if(rows>0){
           return  success();
       }
       return  error();

    }

    /**
     * 保存
     * @param injuryHandle
     * @return
     */
    @ApiOperation("伤病证明申请保存")
    @PostMapping("/save")
    public AjaxResult save(InjuryHandle injuryHandle){
       int rows=injuryHandleService.save(injuryHandle);
       if (rows>0){
           return success();
       }
       return error();

    }


}
