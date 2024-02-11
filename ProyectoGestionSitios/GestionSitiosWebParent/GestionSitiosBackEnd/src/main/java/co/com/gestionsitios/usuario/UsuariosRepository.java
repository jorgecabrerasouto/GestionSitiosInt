package co.com.gestionsitios.usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.gestionsitios.common.entity.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE u.email=:email")
	public Usuario getUsuarioByEmail(@Param("email") String email);
	
}
