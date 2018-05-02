package test.IDao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import test.domain.Student;
import test.domain.User;

import java.util.List;

/*
     * @Description:
     * @Author:  5385
     * @Date:  2018/4/26
     * @Time:  11:31
*/
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 自定义mapper.xml中的resultType类型
     *
     * @param id
     * @return
     */
    Student selectByAge(String id);

    List<Student> selectRightAge();
}