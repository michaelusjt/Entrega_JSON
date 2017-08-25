package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;
import service.VendedorService;
import util.JSonFacade;

@WebServlet("/usuario")
public class ServicoManterUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}
	/*
	 * listar clientes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("chave");
		VendedorService vendedor = new VendedorService();
		ArrayList<Usuario> lista = null;

		PrintWriter out = response.getWriter();

		try {
			if (chave != null && chave.length() > 0) {
				lista = vendedor.listarUsuarios(chave);
			} else {
				lista = vendedor.listarUsuarios();
			}
			out.println(JSonFacade.listToJSon(lista));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
		
	}

	/*
	 * inclusão de usuario
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			int id = us.criar(usuario);
			usuario.setId(id);
			//retorna o usuario cadastrado com o id atribuido pelo banco
			out.println(JSonFacade.usuarioToJSon(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	/*
	 * atualiza usuario
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			us.atualizar(usuario);
			//retorna o usuario atualizado
			out.println(JSonFacade.usuarioToJSon(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	/*
	 * exclusão de usuario
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			us.excluir(usuario.getId()); 
			usuario = us.carregar(usuario.getId());
			//retorna dados null se o usuario foi deletado
			out.println(JSonFacade.usuarioToJSon(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
}
