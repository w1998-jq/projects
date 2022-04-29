package com.wang.seckillrabbit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.seckillrabbit.pojo.User;
import com.wang.seckillrabbit.vo.RespBean;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jqwang
 * @version 1.0
 * @description: TODO
 * @date 2022/4/26 14:20
 */
public class UserUtil {
    public static void createUser(int count) throws Exception {
        List<User> users = new ArrayList<>();
        for(int i = 0;i < count;i ++){
            User user = new User();
            user.setId(13000000000l + i);
            user.setNickname("user" + i);
            user.setSalt("1a2b3c4d");
            user.setLoginCount(1);
            user.setRegisterDate(new Date());
            user.setPassword(MD5Util.inputPassToDBPass("123456",user.getSalt()));
            users.add(user);
        }
        System.out.println("create User");
        /*Connection conn = getConn();
        String sql = "insert into t_user(login_count,nickname,register_date,salt,password,id) values(?,?,?,?,?,?)";
        PreparedStatement pstmp = conn.prepareStatement(sql);
        for(int i =0;i < users.size();i ++){
            User user = users.get(i);
            pstmp.setInt(1,user.getLoginCount());
            pstmp.setString(2,user.getNickname());
            pstmp.setTimestamp(3,new Timestamp(user.getRegisterDate().getTime()));
            pstmp.setString(4,user.getSalt());
            pstmp.setString(5,user.getPassword());
            pstmp.setLong(6,user.getId());
            pstmp.addBatch();
        }
        pstmp.executeBatch();
        pstmp.clearParameters();
        conn.close();
        System.out.println("插入完毕");*/
        //登录，获取cookie
        String urlString = "http://localhost:8080/login/doLogin";
        File file = new File("D:\\config1.txt");
        if(file.exists()){
            file.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        raf.seek(0);
        for(int i = 0;i < users.size();i ++){
            User user = users.get(i);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            String params = "mobile=" + user.getId() + "&password=" + MD5Util.inputPasswordToFromPass("123456");
            outputStream.write(params.getBytes());
            outputStream.flush();
            InputStream in = connection.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while((len = in.read(buff)) >= 0){
                bout.write(buff,0,len);

            }
            in.close();
            bout.close();
            String response = new String(bout.toByteArray());
            ObjectMapper mapper = new ObjectMapper();
            RespBean respBean = mapper.readValue(response, RespBean.class);
            String userTicket = (String) respBean.getObj();
            System.out.println("create userTicket");
            String row = user.getId() + "," + userTicket;
            raf.seek(raf.length());
            raf.write(row.getBytes());
            raf.write("\r\n".getBytes());
            System.out.println("write to file :" + user.getId());
        }
        raf.close();
        System.out.println("over");
    }

    private static Connection getConn() throws Exception {
        String url = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "w.1998";
        Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
    }

    public static void main(String[] args) throws Exception {
        createUser(5000);
    }
}