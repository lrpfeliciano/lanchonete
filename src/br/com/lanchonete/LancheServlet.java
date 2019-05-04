package br.com.lanchonete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lanchonete.dao.LancheDao;
import br.com.lanchonete.model.Lanche;

/**
 * Servlet implementation class LancheServlet
 */
@WebServlet("/processa_lanche")
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
		

		LancheDao dao = new LancheDao();
		Lanche lanche = dao.buscar(codigo);
		
		double valor = lanche.getPreco() * quantidade;
		
		request.setAttribute("cardapio", valor);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("resposta.jsp");
		rd.forward(request, response);
		
	}

}
