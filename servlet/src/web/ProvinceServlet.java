package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/4 17:16
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*没有redis时的操作
        // 调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> provinces = service.findAll();
        // 序列化list为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(provinces);*/

        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println(json);
        // 响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
