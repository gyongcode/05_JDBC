package com.gyong.section02.update;

import static com.gyong.common.JDBCTemplate.close;
import static com.gyong.common.JDBCTemplate.commit;
import static com.gyong.common.JDBCTemplate.getConnection;
import static com.gyong.common.JDBCTemplate.rollback;

import com.gyong.section01.insert.Menu;
import java.sql.Connection;

/*
 * Service 계층 : 비즈니스 로직을 구현하는 계층
 * 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
 */
public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void modifyMenu(Menu menu) {
        System.out.println("[MenuService] modifyMenu : menu ===> " + menu);

        Connection con = getConnection();
        int result = menuRepository.updateMenu(con, menu);

        // 수행 결과에 따라서 Commit, Rollback 정해야한다.
        if (result > 0) {
            commit(con);
            System.out.println("commit");
        } else {
            rollback(con);
            System.out.println("rollback");
        }

        close(con);

        System.out.println("[MenuService] modify end");
    }
}
