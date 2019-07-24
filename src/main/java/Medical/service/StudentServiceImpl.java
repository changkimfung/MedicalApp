package Medical.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Medical.domain.Student;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.StudentMapper;

/**
 *   学生表 服务层实现类
 * @author zhengjianfeng
 * @date 2018-12-13
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentmapper;

	//@Override 的作用是：如果想重写父类的方法，比如toString()方法的话，在方法前面加上@Override 系统可以帮你检查方法的正确性。
    //Override的用法：Override：java.lang.Override是一个marker annotation类型
	//，它被用作标注方法。它说明了被标注的方法重载了父类的方法，起到了断言的作用
	@Override
	
	/**
	 * 分页查询
	 */
	public TableDataInfo selectUserList(Student student){
			
			PageUtil.startPage(student);
			List<Student> list =studentmapper.selectStudentListPage(student);
		    return PageUtil.getDataTable(list);   	
	}
	
	 /**
	  * 删除
	  */
		@Override
		  public Integer  deleteStudentById(@Param(value="uid") String uid) {
		   
		 	 	return studentmapper.deleteStudentById(uid);
	   }
		
		/**
		 *  查询所有学生列表  
		 * @param uid
		 * @return
		 */ 
		@Override
	      public Student selectStudentListById(String uid) {

				return studentmapper.selectStudentListById(uid);
	    }
	    /**
		 *  修改学生列表 
		 * @param student
		 * @return
		 */    
	    @Override
		  public Integer  updateStudent(Student student) {

	      		return studentmapper.updateStudent(student);
		}

		   /**
			 *  新增学生列表 
			 * @param student
			 * @return
			 */  
		@Override
		public Integer insertStudent(Student student) {
			// TODO 自动生成的方法存根
				return studentmapper.insertStudent(student);
	}
		
		/**
		 *  保存学生列表 
		 * @param student
		 * @return
		 */  
		
		@Override
		public Integer saveStudent(Student student) {
			// TODO 自动生成的方法存根
			String uid=student.getUid();
			//操作的行数 因为insert跟update返回的都是rows 都是受影响的行数
			int rows=0;
			if(StringUtils.isNotNull(uid))	{
				rows=studentmapper.updateStudent(student);
			}
			else {
				Date date =new Date();
				long a =date.getTime();
				String a1="010"+String.valueOf(a);
				student.setUid(a1);
				student.setStatus("1");
				rows=studentmapper.insertStudent(student);
			}

			return rows;
		}
       
		/**
		 * 批量删除学生列表 
		 * @param ids
		 * @return
		 */    
		public Integer  deleteStudentByIds(String ids) {
			return studentmapper.deleteStudentByIds(StringUtils.toStrArray(ids));
		}
		
	
}
