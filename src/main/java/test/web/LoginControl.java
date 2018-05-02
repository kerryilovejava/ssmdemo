package test.web;

/**
 * Desc:
 * Created by 5385 on 2018/4/19  14:32.
 */

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录认证的控制器
 */
@Controller
@RequestMapping(value = "/Login")
public class LoginControl {
    /**
     * 登录
     *
     * @param session  HttpSession
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpSession session, String username, String password) throws Exception {
        //在Session里保存信息
        session.setAttribute("username", username);
        return "hello";
    }

    /**
     * 退出系统
     *
     * @param session Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        //清除Session
        session.invalidate();

        return "hello";
    }


}
