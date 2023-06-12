package com.jpa_spring.classes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Indica que esta classe será a Controller
@RequestMapping(path = "/jpa_spring") // A URL de começo será a /jpa_spring (depois do Application path)
// @RequestMapping maps all HTTP operations.
public class UserController {
	@Autowired // Indica a chamada do userRepository
	// Auto gerado pelo Spring => irá auxiliar  no manejo dos dados
	private UserRepository userRepository;

	@PostMapping(path = "/cadastrar") // Mapeia somente as solicitações do tipo POST
	public @ResponseBody String cadastrarUser(@RequestParam String name, @RequestParam String email) {
// @ResponseBody significa que a String retorno é a resposta, não uma view name
// @RequestParam significa que é um parâmetro vindo da requisição GET ou POST

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "User salvo!";
	}

	@GetMapping(path = "/listar")
	public @ResponseBody Iterable<User> listarUser() {
// Retorna um JSON ou XML com os usuários
		return userRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public @ResponseBody String updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setName(name);
	        user.setEmail(email);
	        userRepository.save(user);
	        return "User atualizado";
	    } else {
	        return "User não encontrado";
	    }
	}
	
	
	@GetMapping("/excluir/{id}")
	public @ResponseBody String excluirUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return "User excluído";
		
	}
}


