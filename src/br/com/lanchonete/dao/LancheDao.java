package br.com.lanchonete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lanchonete.model.Lanche;

public class LancheDao extends Conexao {

	public List<Lanche> listar (){
		List<Lanche> lista = new ArrayList<Lanche>();
		
		String sql = "select * from lanche";
		
		try {
			PreparedStatement ps = getConexao()
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Lanche lanche;
			while (rs.next()) {
				lanche = new Lanche();
				lanche.setCodigo(rs.getInt("codigo"));
				lanche.setNome(rs.getString("nome"));
				lanche.setPreco(rs.getDouble("preco"));
				
				lista.add(lanche);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public Lanche buscar(int codigo) {
		Lanche sanduiche = null;
		
		String sql = "select * from lanche where codigo = ?";

		try {
			PreparedStatement ps = getConexao()
					.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				sanduiche = new Lanche();
				sanduiche.setCodigo(rs.getInt("codigo"));
				sanduiche.setNome(rs.getString("nome"));
				sanduiche.setPreco(rs.getDouble("preco"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sanduiche;
		
	}
}
