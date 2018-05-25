package com.dragon.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ljn
 * @date 2018/5/25.
 */
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/image/2.jpg");
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        resp.setHeader("content-disposition","attachment:filename="+fileName);
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(path);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = resp.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
        } finally {
            in.close();
            out.close();
        }
    }
}
