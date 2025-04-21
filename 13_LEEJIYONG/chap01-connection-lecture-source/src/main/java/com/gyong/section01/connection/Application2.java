package com.gyong.section01.connection;

/* import static은 메소드명까지 작성하며 static메소드를 '클래스명'을 생략하고 호출할 수 있다. */

import static com.gyong.section2.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Properties;

public class Application2 {

    public static void main(String[] args) {
        Properties props = new Properties();
        Connection con = null;

       /* try {
            props.load(
                new FileReader(
                    "src/main/java/com/gyong/section01/connection/jdbc.config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = (String) props.getProperty("user");
            String password = (String) props.getProperty("password");

            Class.forName(dirver);
            */
        /* 설정 정보는 유지보수성을 위해 리터럴 값으로 작성하지 않고 별도의 파일로 분리한다. *//*
            con = DriverManager.getConnection(url, props);


            System.out.println("con = " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }*/
        try {
            con = getConnection();
            System.out.println("con " + con);

            // 내가 원하는 시점에 종료
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
