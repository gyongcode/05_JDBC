package com.gyong.section03.delete;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.commit;
import static com.gyong.common.JDBCTemplate.getConnection;
import static com.gyong.common.JDBCTemplate.rollback;

import java.sql.Connection;

public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService() {
        menuRepository = new MenuRepository();
    }

    public void removeMenu(int menuCode) {
        Connection con = getConnection();

        int result = menuRepository.deleteMenu(con, menuCode);
        if (result > 0) {
            commit(con);
            System.out.println("삭제완료");
        } else {
            rollback(con);
            System.out.println("삭제실패");
        }

        close(con);
    }
}
