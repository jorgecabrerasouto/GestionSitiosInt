package co.com.gestionsitios.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gestionsitios.common.entity.Usuario;

@Service
public class ServicioUsuarios {

	@Autowired
	private UsuariosRepository repo;
	
	public List<Usuario> listAll() {
		return (List<Usuario>) repo.findAll();
		
	}
	
}
