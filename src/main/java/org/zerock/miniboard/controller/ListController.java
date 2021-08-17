package org.zerock.miniboard.controller;

import org.zerock.miniboard.dto.BoardDTO;
import org.zerock.miniboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<BoardDTO> boardDTOS = BoardService.INSTANCE.getList();

        request.setAttribute("boardList", boardDTOS);

        request.getRequestDispatcher("/WEB-INF/board/list.jsp")
                .forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
