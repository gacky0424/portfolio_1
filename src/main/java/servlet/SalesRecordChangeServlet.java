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
import model.Stock;
import model.StockCheckLogic;

/**
 * Servlet implementation class SalesRecordChangeServlet
 */
@WebServlet("/SalesRecordChangeServlet")
public class SalesRecordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");

		//ログインしてるかどうか確認、していなかった場合はログインサイトに飛ばす
		if(loginUser!=null) {
			//ページに表示する商品データを得るためのStockCheckLogicインスタンスを生成する
			StockCheckLogic stockCheckLogic = new StockCheckLogic();

			//商品データを格納するためのコレクションインスタンスを生成し、データを得てインスタンスに格納
			List<Stock> productsList = stockCheckLogic.executeFindAll();

			//商品データをアプリケーションスコープに保存
			ServletContext app = this.getServletContext();
			app.setAttribute("productsList", productsList);

			//フォワード先
			String forwardPath = null;

			//動作を決定するためのaction
			String action = request.getParameter("action");

			if (action == null) {
				//フォワード先を設定
				forwardPath = "WEB-INF/jsp/recordDelete.jsp";
			} else if (action.equals("done")) {
				forwardPath = "WEB-INF/jsp/recordInsert.jsp";
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);

		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NoAccountServlet");
			dispatcher.forward(request, response);
		}


	}
}
