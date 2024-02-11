package co.com.gestionsitios.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerUsuario {

	@Autowired
	private ServicioUsuarios servicio;
	
	@PostMapping("/usuarios/chequear_email")
	public String chequearEmailDuplicado (@Param ("email") String email) {
		return servicio.esEmailUnico(email) ? "OK" : "Duplicado";
		
	}
}
