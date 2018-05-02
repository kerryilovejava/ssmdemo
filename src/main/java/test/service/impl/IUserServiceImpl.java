package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.IDao.UserMapper;
import test.domain.Student;
import test.domain.User;
import test.service.IUserService;

import java.util.List;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public Student selectTestByAge(String id) {
        return userMapper.selectByAge(id);
    }

    @Override
    public List<Student> selectRightAge() {
        return userMapper.selectRightAge();
    }


}
