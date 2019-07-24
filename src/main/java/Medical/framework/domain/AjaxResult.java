package Medical.framework.domain;



import java.util.HashMap;

import Medical.framework.page.TableDataInfo;

/**
 * 操作消息提醒
 * 
 */
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult()
    {
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
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }


    public static AjaxResult loginSuccess(String msg,String token)
    {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 0);
        json.put("token", token);
        return json;
    }

    /**
     * 返回成功结果消息
     * @param code
     * @param object
     * @return
     */
    public static AjaxResult success(int code,Object object)
    {
        AjaxResult json = new AjaxResult();
        json.put("data", object);
        json.put("code", code);
        return json;
    }

    /**
     *返回成功结果消息
     * @param message 消息
     * @param object 结果
     * @return
     */
    public static AjaxResult success(String message,Object object)
    {
        AjaxResult json = new AjaxResult();
        json.put("code", 0);
        json.put("data", object);
        json.put("msg", message);
        return json;
    }
  
}

