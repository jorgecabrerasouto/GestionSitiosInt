package co.com.gestionsitios.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.gestionsitios.common.entity.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer>{

}
