package br.edu.infnet.springsecurity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.springsecurity.model.Anime;
import br.edu.infnet.springsecurity.model.AnimeAux;
import br.edu.infnet.springsecurity.model.User;
import br.edu.infnet.springsecurity.repository.UserRepository;
import br.edu.infnet.springsecurity.service.AnimeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@Controller
@EnableFeignClients
public class MainController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String root(Model model) {
        List<AnimeAux> lista = animeService.buscarAnime("attack").results;
        model.addAttribute("lista", lista);
        model.addAttribute("animeAux", new Anime());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());

        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/{id}")
    public String rootFavoritarGet(@PathVariable("id") int id) {

        System.out.println(id);

        return "index";
    }

    @PostMapping("/{id}")
    public String rootFavoritar(@PathVariable("id") int id, @ModelAttribute("anime") Anime animeAux, ModelMap model) {

        System.out.println(animeAux.getTitle());

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
