package com.gyong.section02.prepared;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application3 {

    private static String empId = "201";
    private static String empName = "홍길동";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query =
            "SELECT * FROM employee where emp_id = '" + empId + "'OR 1=1 AND emp_name = '" + empName
                + "'";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                System.out.printf("%s %s\n", rset.getString(1), rset.getString(2));
            } else {
                System.out.println("회원정보가 없습니다.");
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
