package com.gyong.section01.statement;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Application1 {


    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println("con " + con);

        Statement stmt = null;  // 쿼리를 운반하고 결과를 반환
        ResultSet rset = null;   // 조회할 예정 (DML 작업이라면 ResultSet 대신 int로 처리)

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM tbl_menu");

//            while (rset.next()) {
//                System.out.print(rset.getString("menu_name") + " ");
//                System.out.print(rset.getInt("menu_price") + "\n");
//            }

            ArrayList<MenuDTO> list = null;
            list = new ArrayList<>();

            while (rset.next()) {
                list.add(new MenuDTO(rset.getString("menu_name"), rset.getInt("menu_price")));
            }

            for (MenuDTO dto : list) {
                System.out.println(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}


