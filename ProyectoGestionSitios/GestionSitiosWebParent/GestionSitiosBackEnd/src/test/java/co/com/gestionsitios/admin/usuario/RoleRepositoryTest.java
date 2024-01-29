package co.com.gestionsitios.admin.usuario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import co.com.gestionsitios.common.entity.Role;
import co.com.gestionsitios.usuario.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "Gestiona todo");
		Role savedRole = repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	@Test
	public void testCreateRestRoles() {
		Role role1 = new Role ("Role 1", "Descripcion (Role 1)");
	}
}
