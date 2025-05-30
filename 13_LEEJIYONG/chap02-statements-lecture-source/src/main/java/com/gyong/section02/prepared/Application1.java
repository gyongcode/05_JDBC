package com.gyong.section02.prepared;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null; //

        try {
            pstmt = con.prepareStatement("SELECT menu_name, menu_price from tbl_menu");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s  %d\n", rset.getString("menu_name"),
                    rset.getInt("menu_price"));
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
