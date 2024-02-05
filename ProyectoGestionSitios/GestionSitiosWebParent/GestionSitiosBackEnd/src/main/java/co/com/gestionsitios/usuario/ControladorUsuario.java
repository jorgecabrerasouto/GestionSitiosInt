package co.com.gestionsitios.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.gestionsitios.common.entity.Role;
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
	
	@GetMapping("/usuarios/nuevo")
	public String usuarioNuevo (Model model) {
		List<Role> listaRoles = service.listaRoles();
		Usuario usuario = new Usuario();
		usuario.setActivo(true);
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaRoles", listaRoles);
		
		return "forma_usuario";
	}
	
	@PostMapping("/usuarios/guardar")
	public String  guargarUsuario(Usuario usuario,RedirectAttributes redirectAttributes) {
		System.out.println(usuario);
		service.save(usuario);
		
		redirectAttributes.addFlashAttribute("message", " el Usuario fue adicionado exitosamente.");
		
		return "redirect:/usuarios";
	}
	
}
