package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @author ljn
 * @date 2018/5/18.
 */
@RestController
@RequestMapping("demo")
public class ControllerDemo extends HttpServlet{

    private List<String> list;

    private static int s = 0 ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * 压缩数据并返回
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("test")
    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String str = "大丈夫生于天地之间，当读圣贤之书，养浩然正气，仿天地之德以爱人，效圣贤之志以成业。纵使无法成千秋事业，当时正己修心，积善取恶，也得心地坦荡，身性纯洁，也不失位丈夫之举。\n" +
                "古人云，上思报祖宗之德，下思盖父母之愆，远思报国之恩，下思造家之福，外思救人之急，内思正己之邪，当无愧于天地，无愧于祖宗，无愧于父母。沉溺酒色，终究自取灭亡，事业不成，德行不进，凶恶之兆也，远者损其现福，近者将其百秧，不可不深思之。况能者观乎四体而明察其心，若被识破，岂不自取其辱，自断福路乎？\n" +
                "精满则神旺，神旺则气盛，气盛则正气足，正气足则邪不可干。如此，方能美满家庭，成就事业。色情者，过眼云南尔，耗精损气，精竭则人亡，气虚则百病生，报名尚且不足，何谈建功立业。更甚者，身心相通，身残则心虚，心虚则处事不明，祸患不远也。\n" +
                "上天不加悔罪之人，若能发耻悔改，永不再犯，又能积德心善，福气不招自来，命运不加自改，此之谓实学也。\n";
        System.out.println("原始数据大小:"+str.length());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(str.getBytes());
        gout.close();
        byte[] gzip = bout.toByteArray();
        System.out.println("压缩后的大小:"+gzip.length);
        response.setHeader("Content-Encoding","gzip");
        response.setHeader("Content-Length",gzip.length+"");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getOutputStream().write(gzip);

    }

    /**
     * 定时刷新
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("refresh")
    public void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        s++;
        response.setHeader("refresh","3");
        String str = "天下风云出我辈，\n" + "</br>"+
                "一入江湖岁月催。\n" + "</br>"+
                "皇图霸业谈笑中，\n" + "</br>"+
                "不胜人生一场醉。"+"</br>";
        str += s+"";
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getOutputStream().write(str.getBytes());
    }

    /**
     * 重定向
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("location")
    public void location(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(302);
        response.setHeader("location","/1.html");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
    }

    @RequestMapping("image")
    public void image(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type","image/jpeg");
        InputStream in = getServletContext().getResourceAsStream("/image/1.jpg");
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }
        out.close();

//        //读取本地图片输入流
//        FileInputStream inputStream = new FileInputStream("E:/gitRepository/myself/DragonBallZ/src/main/webapp/image/1.jpg");
//        int i = inputStream.available();
//        //byte数组用于存放图片字节数据
//        byte[] buff = new byte[i];
//        inputStream.read(buff);
//        //记得关闭输入流
//        inputStream.close();
//        //设置发送到客户端的响应内容类型
//        response.setContentType("image/*");
//        OutputStream out = response.getOutputStream();
//        out.write(buff);
//        //关闭响应输出流
//        out.close();
    }

    @RequestMapping("range")
    public void range(HttpServletRequest request, HttpServletResponse response) throws IOException {
        URL url = new URL("http://localhost:8082/ziliao.txt");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Range","bytes=5-");
        InputStream in = conn.getInputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        FileOutputStream out = new FileOutputStream("c:\\b.txt", true);
        while((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public BaseResponse createOrder(){
        BaseResponse response = new BaseResponse();
        try{
            getList();
            for (int i = 0;i<10;i++) {
                list.add(i+"");
                System.out.println(list);
            }
            response.setResult(list);
        }catch (RuntimeException e) {
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    private List<String> getList(){
        list = new ArrayList<>();
        return list;
    }

}
