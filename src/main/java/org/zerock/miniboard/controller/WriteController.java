package org.zerock.miniboard.controller;

import org.zerock.miniboard.dto.BoardDTO;
import org.zerock.miniboard.service.BoardService;
import sun.nio.cs.UTF_8;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WriteController", value = "/board/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //게시물 등록 화면
        request.getRequestDispatcher("/WEB-INF/board/register.jsp")
                .forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");

        BoardDTO boardDTO = BoardDTO.builder().title(title).content(content).writer(writer).build();

        BoardService.INSTANCE.register(boardDTO);

        //리다이렉트
        response.sendRedirect("/board/list");

        //title content writer 파라미터
    }
}
