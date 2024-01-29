package co.com.gestionsitios.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.gestionsitios.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
