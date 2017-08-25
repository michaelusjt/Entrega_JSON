package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonFacade {
	
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Usuario> lista) {
		JSONArray vetor = new JSONArray();
		for (Usuario to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getId());
				object.put("nome", to.getNome());
				object.put("cpf", to.getCpf());
				object.put("rg", to.getRg());
				object.put("endereco", to.getEndereco());
				object.put("dataDeNascimento", to.getDataDeNascimento());
				object.put("nomeEmpresa", to.getNomeEmpresa());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Usuario jSonToUsuario(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String nome = registro.getString("nome");
			String cpf = registro.getString("cpf");
			String rg = registro.getString("rg");
			String endereco = registro.getString("endereco");
			String dataDeNascimento = registro.getString("dataDeNascimento");
			String nomeEmpresa = registro.getString("nomeEmpresa");
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setCpf(cpf);
			usuario.setRg(rg);
			usuario.setEndereco(endereco);
			usuario.setDataDeNascimento(dataDeNascimento);
			usuario.setNomeEmpresa(nomeEmpresa);
			return usuario;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String usuarioToJSon(Usuario usuario) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", usuario.getId());
			object.put("nome", usuario.getNome());
			object.put("cpf", usuario.getCpf());
			object.put("rg", usuario.getRg());
			object.put("endereco", usuario.getEndereco());
			object.put("dataDeNascimento", usuario.getDataDeNascimento());
			object.put("nomeEmpresa", usuario.getNomeEmpresa());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
