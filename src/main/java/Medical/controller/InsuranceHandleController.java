package Medical.controller;

import Medical.domain.InsuranceHandle;
import Medical.framework.Util.StringUtils;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.InsuranceHandleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 业务操作控制器
 * @author  zjf
 * @date 2019/01/14
 */

@Api("医保报销业务")
@RestController
@RequestMapping("/InsuranceHandle")
public class InsuranceHandleController extends BaseController {


    @Autowired
    private InsuranceHandleService insuranceHandleService;

    /**
     * 分页查询功能
     * @param insuranceHandle
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("医保报销申请查询")
    @GetMapping("/list")
    public AjaxResult list(InsuranceHandle insuranceHandle, Integer pageNum, Integer pageSize){
        insuranceHandle.setPageNum(pageNum);
        insuranceHandle.setPageSize(pageSize);

        TableDataInfo list=insuranceHandleService.selectInsuranceHandleListPage(insuranceHandle);
        return success("",list);

    }

    /**
     * 编辑功能
     * @param uid
     * @return
     */
    @ApiOperation("医保报销申请编辑")
    @GetMapping("/edit/{uid}")
    public AjaxResult edit(@PathVariable("uid")String uid){
        InsuranceHandle insuranceHandle=insuranceHandleService.selectInsuranceHandleById(uid);
        return success("",insuranceHandle);
    }


    /**
     * 删除功能
     * @param uid
     * @return
     */
    @ApiOperation("医保报销申请删除")
    @PostMapping("/remove")
    public  AjaxResult remove(String uid){
        String[] ids=null;

        if (StringUtils.isNotEmpty(uid)){
            ids=uid.split(",");
        }
        int rows =insuranceHandleService.deleteInsuranceHandle(ids);
        if(rows>0){
            return success();
        }
        return error();
    }


    /**
     * 保存功能
     * @param insuranceHandle
     * @return
     */
    @ApiOperation("医保报销申请保存")
    @PostMapping("/save")
    public  AjaxResult save (InsuranceHandle insuranceHandle){
        int rows=insuranceHandleService.save(insuranceHandle);
        if (rows>0){
            return success();
        }
        return error();
    }

}
