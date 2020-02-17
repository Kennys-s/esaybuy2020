package Student.cn.bdqn.servlet;

import Student.cn.bdqn.entity.Grade;
import Student.cn.bdqn.service.GradeService;
import Student.cn.bdqn.service.impl.GradeServiceImpl;
import Student.cn.bdqn.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/grade.sv")
public class GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//编码格式
        response.setContentType("text/html;charset=utf-8");
        GradeService service=new GradeServiceImpl();
        String name=request.getParameter("Pageindex");
        int index=1;
        if (name!=null&&name!=""){
            index=Integer.parseInt(name);
        }
        if (index<=0){
            index=1;
        }
        int count=service.count();
      Page p=new Page();
      p.setTotalCount(count);
      int pageCount=p.getTotalPageCount();
      if (index>pageCount){
          index=pageCount;
      }
      p.setPageIndex(index);
      List<Grade> list=service.list(p.getPageIndex(),p.getPageSize());
      request.setAttribute("list",list);
      request.setAttribute("index",p.getPageIndex());
      request.setAttribute("count",p.getTotalPageCount());
      request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
