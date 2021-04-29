package tomcat_test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({ "serial", "unused" })
public class HelloServlet extends HttpServlet {

	static final String head="<head><title>sample</title></head>";
	static final String msg="<div class='msg' id='message'>ここにテキストを書き込みます。</div>";
	static final String form="<form method='post'>"
			+"<p><textarea name='name' cols='60' rows='4'></textarea></p>"
			+"<p><input name='send' value='write' type='submit' /></p>"
			+"</form>";
	
	static String result="";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//super.doGet(req, resp);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println(head);
		out.println("<body>");
		out.println(msg);
		out.println(form);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//super.doPost(req, resp);
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		try {
			if(req.getParameter("send").equalsIgnoreCase("write")) {
				result+="<hr><br>"+req.getParameter("name")+"<br>";
			}
		}catch(Exception e) {
			e.printStackTrace();
			result="書き込みに失敗しました<br>"+e.getMessage();
		}
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println(head);
		out.println("<body>");
		out.println(msg);
		out.println(form);
		out.println(result);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
