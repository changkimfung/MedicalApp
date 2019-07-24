package Medical.controller;

import Medical.domain.Drug;
import Medical.framework.Util.StringUtils;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static Medical.framework.domain.AjaxResult.success;

/**业务操作层
 * @author  zjf
 * @date    2019/01/14
 */


@Api("药物维护")
@RestController
@RequestMapping("/Drug")
public class DrugController extends BaseController {

    @Autowired
    private DrugService drugservice;

    /**
     * 分页查询
     * @param drug
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("药品查询")
    @GetMapping("/list")
    public AjaxResult list(Drug drug,Integer pageNum,Integer  pageSize){
        drug.setPageNum(pageNum);
        drug.setPageSize(pageSize);
        TableDataInfo list =drugservice.selectDrugPage(drug);
        return success("",list);
    }

    /**
     * 编辑
     * @param uid
     * @return
     */
    @ApiOperation("药品编辑")
    @GetMapping("/edit/{uid}")
    public AjaxResult edit(@PathVariable("uid") String uid){
        Drug drug =drugservice.selectDrugById(uid);
        return success("",drug);
    }

    /**
     * 删除
     * @param uid
     * @return
     */
    @ApiOperation("药品删除")
    @PostMapping("/remove")
    public AjaxResult remove(String uid){
        String[] ids =null;
        if(StringUtils.isNotEmpty(uid)){

            ids=uid.split(",");
        }
        int rows= drugservice.deleteDrug(ids);
        if(rows>0) {
            return success();
        }
        return error();
        }

    /**
     * 保存
     * @param drug
     * @return
     */

    @ApiOperation("药品保存")
    @PostMapping("/save")
    public AjaxResult save(Drug   drug){
        int rows=0;
        rows=drugservice.save(drug);
        if (rows >0){
            return success();
        }
        return  error();
    }
}
