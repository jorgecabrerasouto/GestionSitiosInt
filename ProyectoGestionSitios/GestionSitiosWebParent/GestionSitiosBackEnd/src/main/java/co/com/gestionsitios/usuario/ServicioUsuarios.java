package co.com.gestionsitios.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.gestionsitios.common.entity.Role;
import co.com.gestionsitios.common.entity.Usuario;

@Service
public class ServicioUsuarios {

	@Autowired
	private UsuariosRepository repoUsuario;
	
	@Autowired
	private RoleRepository repoRole;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Usuario> listAll() {
		return (List<Usuario>) repoUsuario.findAll();
		
	}
	
	public List<Role> listaRoles() {
		return (List<Role>) repoRole.findAll();
		
	}
	
	public void save(Usuario usuario) {
		encodePassword(usuario);
		repoUsuario.save(usuario);
	}
	
	private void encodePassword(Usuario usuario) {
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
	}
	public Boolean esEmailUnico(String email) {
		Usuario userByEmail = repoUsuario.getUsuarioByEmail(email);
		
		return userByEmail == null;
	}
	
}
