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

import dao.SalesRecordDAO;
import model.Login;
import model.SalesRecord;
import model.SalesRecordLogic;
import model.Stock;
import model.StockCheckLogic;

@WebServlet("/RecordInsertServlet")
public class RecordInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//ログインしてるかどうか確認、していなかった場合はログインサイトに飛ばす
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");

		if (loginUser != null) {
			//response.sendRedirect();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordCheck.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NoAccountServlet");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//チェックボックスのリクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		String amount = request.getParameter("amount");
		String customer = request.getParameter("customer");

		StockCheckLogic scl = new StockCheckLogic();
		Stock stock = scl.executeFind(productId);
		int amountInt = Integer.parseInt(amount);

		HttpSession session = request.getSession();

		//販売数量は在庫より多いかどうか確認
		if (stock.getProductStock() < amountInt) {
			session.setAttribute("resultMsg", "在庫が足りません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordCheck.jsp");
			dispatcher.forward(request, response);

		} else {
			//アプリケーションスコープに保存していた更新前のデータは捨てる
			ServletContext app = this.getServletContext();
			app.removeAttribute("salesRecordList");

			//追加結果のメッセージを示す
			SalesRecordLogic srl = new SalesRecordLogic();
			String resultMsg = srl.Insert(productId, amount, customer);
			session.setAttribute("resultMsg", resultMsg);

			//更新後のデータのインスタンスを生成し、データを得る
			SalesRecordDAO srDao = new SalesRecordDAO();
			List<SalesRecord> newSalesRecord = srDao.findAll();

			//更新後のデータをアプリケーションスコープに保存
			app.setAttribute("salesRecordList", newSalesRecord);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordCheck.jsp");
			dispatcher.forward(request, response);
		}
	}

}
