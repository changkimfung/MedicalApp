package Medical.domain;

import Medical.framework.domain.BaseEntity;

/**
 * 医保报销表实体类
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class InsuranceHandle  extends BaseEntity{
		
		
	     /**主键*/
		private String uid;
		/**学生姓名*/
		private String stuName;
	    /**学生ID*/
		private String stuId;	
		/**医保编号*/
		private String insCode;
		/**医生ID*/
		private String docName;
		/**状态*/
		private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getStuName() {
			return stuName;
		}
		public void setStuName(String stuName) {
			this.stuName = stuName;
		}
		public String getStuId() {
			return stuId;
		}
		public void setStuId(String stuId) {
			this.stuId = stuId;
		}
		public String getInsCode() {
			return insCode;
		}
		public void setInsCode(String insCode) {
			this.insCode = insCode;
		}
		public String getDocName() {
			return docName;
		}

		public void setDocName(String docName) {
			this.docName = docName;
		}


}
