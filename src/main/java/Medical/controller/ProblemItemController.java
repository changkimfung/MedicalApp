package Medical.controller;

import Medical.domain.ProblemItem;
import Medical.framework.Util.StringUtils;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.ProblemItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 问题反馈控制器
 * @date 2019/01/14
 * @author zjf
 */

@Api("问题反馈维护")
@RequestMapping("/ProblemItem")
@RestController
public class ProblemItemController  extends BaseController {

    @Autowired
    private ProblemItemService problemItemservice;

    /**
     * 分页查询
     * @param pageSize
     * @param pageNum
     * @param problemItem
     * @return
     */

    @ApiOperation("问题反馈列表查询")
    @GetMapping("list")
    public AjaxResult list(Integer pageSize, Integer pageNum, ProblemItem problemItem){
        problemItem.setPageNum(pageNum);
        problemItem.setPageSize(pageSize);
        TableDataInfo list =problemItemservice.selectProblemItemListPage(problemItem);
        return success("",list);
    }

    /**
     * 删除功能
     * @param uid
     * @return
     */
    @ApiOperation("问题反馈删除")
    @PostMapping("/remove")
    public  AjaxResult remove(String uid){
        String[] ids =null;
        if (StringUtils.isNotEmpty(uid)){
            ids=uid.split(",");
        }
        int rows=problemItemservice.deleteProblemItem(ids);
        if(rows>0){
            return success();
        }
        return  error();
    }

    /**
     * 编辑功能
     * @param uid
     * @return
     */
    @ApiOperation("问题反馈编辑")
    @GetMapping("/edit/{uid}")
    public  AjaxResult  edit(@PathVariable("uid") String uid){
        ProblemItem problemItem =problemItemservice.selectProblemItemById(uid);
        return success("",problemItem);

    }


    /**
     * 保存功能
     * @param problemItem
     * @return
     */
    @ApiOperation("问题反馈保存")
    @PostMapping("/save")
    public AjaxResult save(ProblemItem problemItem){

       int rows=problemItemservice.save(problemItem);
        if(rows>0){
            return success();
        }
        return error();
    }
}
