package Medical.domain;

import Medical.framework.domain.BaseEntity;

/**
 * 问题反馈表实体类
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class ProblemItem extends BaseEntity {
     /**主键*/
	private String uid;
    /**问题详情*/
	private String Content;
    /**编码*/
	private String code;
    /**回答*/
	private String answer;
    
    public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
