package Medical.framework.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import Medical.framework.page.TableDataInfo;

public class BaseController {

	  /**
     * 返回成功消息
     */
	public AjaxResult success(String message, Object result) {
		// TODO 自动生成的方法存根
		  return AjaxResult.success(message,result);
		  
	}
    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 0);
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static AjaxResult error()
    {
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg)
    {
        return error(1, msg);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(int code, String msg)
    {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

 
	/**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
	 @InitBinder
	    protected void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
}
