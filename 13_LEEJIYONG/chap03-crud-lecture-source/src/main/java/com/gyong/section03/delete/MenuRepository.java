package com.gyong.section03.delete;

import static com.gyong.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {

    private final Properties prop;

    public MenuRepository() {
        this.prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/gyong/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteMenu(Connection con, int menuCode) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteMenu");

        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, menuCode);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
