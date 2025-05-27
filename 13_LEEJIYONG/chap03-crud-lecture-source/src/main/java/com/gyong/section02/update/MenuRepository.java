package com.gyong.section02.update;

import static com.gyong.common.JDBCTemplate.close;

import com.gyong.section01.insert.Menu;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {

    private final Properties prop;

    public MenuRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/gyong/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateMenu(Connection con, Menu menu) {
        System.out.println("[MenuRepository] updateMenu ===> " + menu);

        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateMenu");
        System.out.println("sql = " + sql);

        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getMenuCode());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println("[MenuRepository] updateMenu end");
        return result;
    }
}
