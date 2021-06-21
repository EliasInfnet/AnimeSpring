package br.edu.infnet.springsecurity.web;

import java.util.List;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.springsecurity.model.Anime;
import br.edu.infnet.springsecurity.model.AnimeAux;
import br.edu.infnet.springsecurity.model.User;
import br.edu.infnet.springsecurity.repository.AnimeRepository;
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

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/")
    public String root(Model model) {
        List<AnimeAux> lista = animeService.buscarAnime("attack").results;
        model.addAttribute("lista", lista);
        model.addAttribute("animeAux", new Anime());

        // if (listadeanimesdoBD != null) {
        //     imprime na tela: colocando o modelAttribute
        // } else {
        //     não vai renderizar essa lista.
        // }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        

        model.addAttribute("user", user);
        return "index";
    }

   

    @GetMapping("/fav{id}" )
    public String rootFavoritarGet(@RequestParam("id") String animeid , Model model) {

        List<AnimeAux> lista = animeService.buscarAnime("attack").results;
        model.addAttribute("lista", lista);
        model.addAttribute("animeAux", new Anime());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());
        
        List<AnimeAux> animeFav = animeService.buscarAnime(animeid).results;
        AnimeAux animeAux = animeFav.get(0);
        Anime animeSalvando = new Anime(animeAux.getMal_id(),animeAux.getTitle(),animeAux.getSynopsis(),animeAux.getEpisodes(),
        animeAux.getScore(),animeAux.getImage_url(),user.getEmail());
        animeRepository.save(animeSalvando);

        model.addAttribute("user", user);
        
        System.out.println("esse e o  id:"  + animeid);
        System.out.println("fav foi chamado");

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
