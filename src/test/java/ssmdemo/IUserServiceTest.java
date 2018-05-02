package ssmdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.domain.Student;
import test.domain.User;
import test.service.IUserService;

import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IUserServiceTest {
    @Autowired
    public IUserService userService;

    @Test
    public void getUserByIdTest() {

        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUserName());
    }

    @Test
    public void getStudentByAge() {
        Student student = userService.selectTestByAge("1");
        System.out.println(student);
    }

    @Test
    public void getStudentRightAge() {
        List<Student> list = userService.selectRightAge();
        System.out.println(list);
    }


}
