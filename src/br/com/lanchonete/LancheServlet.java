package br.com.lanchonete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LancheServlet
 */
@WebServlet("/LancheServlet")
public class LancheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo = Integer.parseInt( 
				request.getParameter("cboLanche") );
		int quantidade = Integer.parseInt(
				request.getParameter("txtQuantidade") );
		
		double valor = 0;
		if (codigo == 100) {
			valor = 5 * quantidade;
		} else if (codigo == 101) {
			valor = 10 * quantidade;
		} else if (codigo == 102) {
			valor = 10.5 * quantidade;
		} else if (codigo == 103) {
			valor = 5 * quantidade;
		} else if (codigo == 104) {
			valor = 6 * quantidade;
		} else {
			valor = 4 * quantidade;
		}
		
		request.setAttribute("cardapio", valor);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("resposta.jsp");
		rd.forward(request, response);
		
	}

}
