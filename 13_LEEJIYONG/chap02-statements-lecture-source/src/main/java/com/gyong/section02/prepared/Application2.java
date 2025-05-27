package com.gyong.section02.prepared;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입려갛세요 : ");
        int menuCode = sc.nextInt();

        String query = "SELECT menu_name, menu_price FROM tbl_menu WHERE menu_code = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, menuCode);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s, %d", rset.getString(1), rset.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
