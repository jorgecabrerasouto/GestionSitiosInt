package co.com.gestionsitios.usuario;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.gestionsitios.common.entity.Role;
import co.com.gestionsitios.common.entity.Usuario;
import jakarta.transaction.Transactional;


@Service
@Transactional
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
		boolean estaActualizandoUsuario =(usuario.getId() != null);
		
		if(estaActualizandoUsuario) {
			Usuario usuarioExistente = repoUsuario.findById(usuario.getId()).get();
			if (usuario.getPassword().isEmpty()) {
				usuario.setPassword(usuarioExistente.getPassword());
			} else {
				encodePassword(usuario);
			}
		} else {
			encodePassword(usuario);
		}
		
		repoUsuario.save(usuario);
	}
	
	private void encodePassword(Usuario usuario) {
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
	}
	public Boolean esEmailUnico(Integer id, String email) {
		Usuario userByEmail = repoUsuario.getUsuarioByEmail(email);
		
		if(userByEmail == null) return true;
		
		boolean estaCreandoNuevo = (id == null);
		
		if(estaCreandoNuevo) {
			if (userByEmail != null) return false;
		} else {
			if (userByEmail.getId() != id) {
				return false;
			}
		}
		
		return true;
	}

	public Usuario get(Integer id) throws UserNotFoundException {
		try {		
			return repoUsuario.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("No se pudo encontrar un usuario con id " + id);
		}
	}
	
	public void eliminar(Integer id) throws UserNotFoundException {
		Long countById = repoUsuario.countById(id);
		if (countById == null || countById == 0) {
			throw new UserNotFoundException("No se pudo encontrar un usuario con id " + id);
		}
		
		repoUsuario.deleteById(id);
	}
	
	public void actualizarEstadoActivoUsuario (Integer id, boolean active) {
		repoUsuario.actualizarEstadoActivo(id, active);
		
	}
	
}
