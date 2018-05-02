package test.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 5385
 * @Date 2018/4/26
 * @Time 9:17
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 5806037960769141835L;
    private String id;
    private String name;
    private String age;

    public Student() {
    }

    public Student(String id, String name, String age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
