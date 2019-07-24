package Medical.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import Medical.domain.Student;
import Medical.framework.page.TableDataInfo;

/**
 * 学生表服务层
 * @author zhengjianfeng
 * @date 2018-12-13
 */
public interface StudentService {

	/**
	 *  查询所有学生列表 
	 * @param student
	 * @return
	 */
      public TableDataInfo selectUserList(Student student);
 
	/**
	  * 删除
	  * @param uid
	  * @return
	  */
       public Integer  deleteStudentById(@Param(value="uid")String uid);
   
    /**
	  *  查询所有学生列表  
	  * @param uid
	  * @return
	  */  
	   public Student selectStudentListById(String uid);
 	   
	   /**
		 *  修改学生列表 
		 * @param student
		 * @return
		 */    
	    public Integer  updateStudent(@RequestBody Student student);
	
	   /**
		 *  新增学生列表 
		 * @param student
		 * @return
		 */    
	    public Integer insertStudent(@RequestBody Student student);
	    

	   /**
		 *  保存学生列表 
		 * @param student
		 * @return
		 */    
	   public Integer saveStudent(@RequestBody Student student);
		/**
		 * 批量删除学生列表 
		 * @param ids
		 * @return
		 */    
		public Integer  deleteStudentByIds(String ids);
		
}
