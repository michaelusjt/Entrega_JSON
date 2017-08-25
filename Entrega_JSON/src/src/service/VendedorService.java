package service;

import java.io.IOException;
import java.util.ArrayList;

import model.Usuario;
import dao.UsuarioDAO;

public class VendedorService {
	private UsuarioDAO dao;
	
	public VendedorService(){
		dao = new UsuarioDAO();
	}
	public ArrayList<Usuario> listarUsuarios() throws IOException{
		return dao.listarUsuarios();
	}
	public ArrayList<Usuario> listarUsuarios(String chave) throws IOException{
		return dao.listarUsuarios(chave);
	}

}
