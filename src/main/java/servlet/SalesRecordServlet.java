package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.SalesRecord;
import model.SalesRecordLogic;

@WebServlet("/SalesRecordServlet")
public class SalesRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");

		//ログインしてるかどうか確認、していなかった場合はログインサイトに飛ばす
		if(loginUser!=null) {
			//商品のデータを得るためのStockCheckLogicインスタンスを生成する
			SalesRecordLogic salesRecordLogic = new SalesRecordLogic();

			//商品データを格納するためのコレクションのインスタンスを生成し、データを得る
			List<SalesRecord> salesRecordList = salesRecordLogic.executeFindAll();

			//商品データをアプリケーションスコープに保存
			ServletContext app = this.getServletContext();
			app.setAttribute("salesRecordList", salesRecordList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordCheck.jsp");
			dispatcher.forward(request, response);

		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NoAccountServlet");
			dispatcher.forward(request, response);
		}

	}
}
