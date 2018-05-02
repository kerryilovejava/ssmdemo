package test.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.domain.Area;
import test.domain.User;
import test.service.IUserService;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/showname", method = RequestMethod.GET)
    public String showUserName(@RequestParam("uid") int uid, HttpServletRequest request, Model model) {
        System.out.println("showname");
        User user = userService.selectByPrimaryKey(uid);
        if (user != null) {
            // request.setAttribute("name", user.getUserName());
            model.addAttribute("name", user.getUserName());
            return "showName";
        }
        request.setAttribute("error", "没有找到该用户！");
        return "error";
    }

    @RequestMapping(value = "/showtest", method = RequestMethod.GET)
    public void showUserName1(HttpServletRequest request, Model model, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("showname");
        request.setAttribute("test", "外部jsp");
        // model.addAttribute("name", user.getUserName());
        request.getRequestDispatcher("testdemo.jsp").forward(request, response);
        return;
    }

    /**
     * 方法描述:如果文件是图片保存在内存中
     *
     * @param file
     * @param request
     * @throws IOException
     * @date 2018年3月31日
     * @time 下午6:36:59
     * @author 5385
     */
    @RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
    public void doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        // 如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
        } else {
            System.out.println("文件为空");
        }

    }

    /**
     * 方法描述:poi技术excel导入
     *
     * @param file
     * @param request
     * @throws IOException
     * @date 2018年3月31日
     * @time 下午7:27:37
     * @author 5385
     */

    @RequestMapping(value = "/exceltest", method = RequestMethod.POST)
    public void doUploadFile1(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        InputStream is = file.getInputStream();
        ArrayList<Area> areaList = new ArrayList<Area>();
        // 1)打开工作簿
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // 2)打开指定的工作表
        // hssfWorkbook.getSheet("Sheet1");//根据表的名字来读
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);// 根据表的索引来读index of the
        // sheet number (0-based
        // physical & logical)
        // 3)一行一行的读
        // sheet：Sheet extends Iterable<Row>
        for (Row row : sheet) {
            // 略过第一行：第一行往往是标题（指导用户填写表格）
            if (row.getRowNum() == 0) {
                // 第一行略过
                continue;
            }

            // 实体类对象
            Area area = new Area();

            // 读取行的数据(行是由格组成的，一格一格的读)
            String name = row.getCell(0).getStringCellValue();
            String sex = row.getCell(1).getStringCellValue();
            String age = row.getCell(2).getStringCellValue();
            area.setName(name);
            area.setSex(sex);
            area.setAge(age);

            // 将区域添加到集合
            areaList.add(area);

        }
        System.out.println(areaList);
        hssfWorkbook.close();
    }
}