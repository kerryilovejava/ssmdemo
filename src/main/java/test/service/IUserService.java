package test.service;

import test.domain.Student;
import test.domain.User;

import java.util.List;

public interface IUserService {
    User selectByPrimaryKey(Integer id);

    Student selectTestByAge(String id);

    List<Student> selectRightAge();


}
