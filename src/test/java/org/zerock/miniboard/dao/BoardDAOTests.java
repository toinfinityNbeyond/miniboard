package org.zerock.miniboard.dao;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.miniboard.dto.BoardDTO;

@Log4j2
public class BoardDAOTests {

    @Test
    public void testInsertDummies(){

        BoardDTO test1 = BoardDTO.builder().bno(3l).count(0).title("test2").writer("user2").content("test message").build();

        BoardDAO.INSTANCE.insert(test1);

    }

    @Test
    public void selectList(){

        log.info(BoardDAO.INSTANCE.selectList());

    }

}