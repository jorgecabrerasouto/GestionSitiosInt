package co.com.gestionsitios.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.gestionsitios.common.entity.Role;
import co.com.gestionsitios.common.entity.Usuario;

@Service
public class ServicioUsuarios {

	@Autowired
	private UsuariosRepository repoUsuario;
	
	@Autowired
	private RoleRepository repoRole;
	
	public List<Usuario> listAll() {
		return (List<Usuario>) repoUsuario.findAll();
		
	}
	
	public List<Role> listaRoles() {
		return (List<Role>) repoRole.findAll();
		
	}
	
	public void save(Usuario usuario) {
		System.out.println(usuario);
		repoUsuario.save(usuario);
	}
	
}
