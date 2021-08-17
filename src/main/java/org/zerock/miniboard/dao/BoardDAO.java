package org.zerock.miniboard.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.miniboard.dto.BoardDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Log4j2
public enum BoardDAO {

    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_board (count, title, writer, content) values ( ?, ?, ?, ?)";

    private static final String SQL_LIST = "select bno, title, writer, count, regdate \n" +
            "from tbl_board order by bno desc";

    public void insert(BoardDTO boardDTO) throws RuntimeException{

        new JdbcTemplate(){
            @Override
            protected void execute() throws Exception {
                int idx=1;
                preparedStatement = connection.prepareStatement(SQL_INSERT);
                preparedStatement.setInt(idx++, boardDTO.getCount());
                preparedStatement.setString(idx++, boardDTO.getTitle());
                preparedStatement.setString(idx++, boardDTO.getWriter());
                preparedStatement.setString(idx++, boardDTO.getContent());

                preparedStatement.executeUpdate();
            }
        }.makeAll();


    }

    public ArrayList<BoardDTO> selectList() throws RuntimeException{
        ArrayList<BoardDTO> list = new ArrayList<>();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_LIST);

                resultSet = preparedStatement.executeQuery();

                log.info(resultSet);
                //"select bno, title, writer, count, regdate \n" +
                //            "from tbl_board order by bno desc";
                while(resultSet.next()){
                    list.add(BoardDTO.builder()
                            .bno(resultSet.getLong(1))
                            .title(resultSet.getString(2))
                            .writer(resultSet.getString(3))
                            .count(resultSet.getInt(4))
                            .regdate(resultSet.getTimestamp(5))
                            .build());
                }

            }
        }.makeAll();
        return list;
    }
}
