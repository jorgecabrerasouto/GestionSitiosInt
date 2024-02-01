package co.com.gestionsitios.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.com.gestionsitios.common.entity.Usuario;

@Controller
public class ControladorUsuario {

	@Autowired
	private ServicioUsuarios service;
	
	@GetMapping("/usuarios")
		public String listAll(Model model) {
		List<Usuario> listaUsuarios = service.listAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "usuarios";
	}
}
