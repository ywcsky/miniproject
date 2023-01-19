package okky.member.controller;

import okky.member.model.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("user-id");
        String userPw = request.getParameter("user-pw");
        MemberService mService = new MemberService();
        int result = mService.findMember(userId,userPw);
        if(result > 0){
            response.sendRedirect("/index.html");
        } else{
            response.setContentType("text/html; charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println("<script>alert('아이디 또는 비밀번호를 확인해주세요.'); location.href='/miniproject/login.html';</script>");
            pw.close();
        }
    }
}
