package service;

import model.UsuarioLogin;
import dao.UsuarioLoginDAO;

public class UsuarioLoginService {
	
	public boolean validar(UsuarioLogin usuarioLogin){
		UsuarioLoginDAO dao = new UsuarioLoginDAO();
		return dao.validar(usuarioLogin);
	}
}
