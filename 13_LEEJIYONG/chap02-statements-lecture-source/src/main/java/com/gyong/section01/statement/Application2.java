package com.gyong.section01.statement;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application2 {

    /* 메뉴코드를 입력받아서 하나의 메뉴를 조회하는 기능 */
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴코드를 입력하세요 : ");
            int menu_code = sc.nextInt();

            String query = "SELECT * FROM tbl_menu WHERE menu_code = " + menu_code;
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                System.out.print(rset.getString("menu_name") + " ");
                System.out.println(rset.getString("menu_code"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

        System.out.println(Integer.toBinaryString(1));
    }
}
