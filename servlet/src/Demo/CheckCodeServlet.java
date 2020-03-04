package Demo;

import com.alibaba.druid.support.jconsole.model.ColumnGroup;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author AceDJH
 * @Date 2020/3/4 20:22
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100, height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 画框
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.ORANGE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 生成验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.drawString(ch + " ", width / 5 * i, height / 2);
        }

        // 画干扰线
        graphics.setColor(Color.green);
        // 随机生成坐标点
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
