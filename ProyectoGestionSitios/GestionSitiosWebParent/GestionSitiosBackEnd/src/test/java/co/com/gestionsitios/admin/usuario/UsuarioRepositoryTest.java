package co.com.gestionsitios.admin.usuario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import co.com.gestionsitios.common.entity.Role;
import co.com.gestionsitios.common.entity.Usuario;
import co.com.gestionsitios.usuario.UsuariosRepository;
import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuariosRepository repo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testCreateUnUsuarioConUnRol() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		Usuario usuarioJCS = new Usuario("jorgecabrerasouto@outlook.com", "jcAbcIwa3#", "Jorge", "Cabrera Souto");
		usuarioJCS.addRole(roleAdmin);
		
		Usuario savedUsuario = repo.save(usuarioJCS); 
		assertThat(savedUsuario.getId()).isGreaterThan(0);
	}

	@Test
	public void testCreateUnUsuarioConDosRoles() {
		Usuario usuarioSES = new Usuario("salazarsalazarse@gmail.com", "ssAbcIwa3#", "Sonia", "Salazar");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		usuarioSES.addRole(roleEditor);
		usuarioSES.addRole(roleAssistant);
		
		Usuario savedUsuario = repo.save(usuarioSES); 
		assertThat(savedUsuario.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<Usuario> listUsuarios =repo.findAll();
		listUsuarios.forEach(usuario -> System.out.println(usuario));
	}
	
	@Test
	public void testGetUsuarioById() {
		Usuario usuarioJCS = repo.findById(1).get();
		System.out.println(usuarioJCS);
		assertThat(usuarioJCS).isNotNull();	
	}
	
	@Test
	public void testUpdateDetallesUsuario() {
		Usuario usuarioJCS = repo.findById(1).get();
		usuarioJCS.setActivo(true);
		usuarioJCS.setEmail("jorgecabrerasouto@gmail.com");
		
		repo.save(usuarioJCS);
		
	}
	
	@Test
	public void testUpdateRolesDeUsuario() {
		Usuario usuarioSES = repo.findById(2).get();
		Role roleEditor = new Role(3);
		Role roleSalesperson = new Role(2);
		
		usuarioSES.getRoles().remove(roleEditor);
		usuarioSES.addRole(roleSalesperson);
		
		repo.save(usuarioSES);
	}
	
	@Test
	public void testDeleteUsuario() {
		Integer idUsuario = 2;
		repo.deleteById(idUsuario);
	}
	
	@Test
	public void testGetUsuarioByEmail() {
		String email = "dennis.mccain@gmail.com";
		Usuario usuario = repo.getUsuarioByEmail(email);

		assertThat(usuario).isNotNull();
	} 
	@Test
	public void testCountById() {
		Integer id = 3;
		Long countById = repo.countById(id);
		
		assertThat(countById).isNotNull().isGreaterThan(0);
		
	}
	
	@Test
	public void testUsuarioInactivo() {
		Integer id = 3;
		repo.actualizarEstadoActivo(id, false);
	}
	
	@Test
	public void testUsuarioActivo() {
		Integer id = 3;
		repo.actualizarEstadoActivo(id, true);
	}
}