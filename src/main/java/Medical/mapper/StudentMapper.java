package Medical.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Medical.domain.Student;

/**
 *   学生表 数据层
 * @author zhengjianfeng
 * @date 2018-12-13
 */
@Mapper
public interface StudentMapper {
	
	/**
	 *  查询所有学生列表 
	 * @param student
	 * @return
	 */
	public List<Student> selectStudentListPage(Student student);
	
	/**
	 *  删除学生列表 
	 * @param id
	 * @return
	 */    
	public Integer  deleteStudentById(String id);
	
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
	public Integer  updateStudent(Student student);
	
    /**
	 *  新增学生列表 
	 * @param student
	 * @return
	 */    
	public Integer insertStudent(Student student);
	/**
	 * 批量删除学生列表 
	 * @param ids
	 * @return
	 */    
	public Integer  deleteStudentByIds(String[] ids);
	
	
	
}
