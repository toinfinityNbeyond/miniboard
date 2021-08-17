package org.zerock.miniboard.service;


import lombok.extern.log4j.Log4j2;
import org.zerock.miniboard.dao.BoardDAO;
import org.zerock.miniboard.dto.BoardDTO;

import java.util.ArrayList;

@Log4j2
public enum BoardService {
    INSTANCE;

    public void register(BoardDTO boardDTO) throws RuntimeException {

        log.info("service register..." + boardDTO);

        BoardDAO.INSTANCE.insert(boardDTO);
    }

    public ArrayList<BoardDTO> getList() throws RuntimeException{

        ArrayList<BoardDTO> result = BoardDAO.INSTANCE.selectList();
        return result;
    }

}
