package br.edu.infnet.springsecurity.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.springsecurity.model.RetornoApi;

@FeignClient(url = "https://api.jikan.moe/v3/search/", name = "animeservice")
public interface AnimeService {

    @GetMapping("anime?q={nome}&rated=pg13")
    RetornoApi buscarAnime(@PathVariable("nome") String nome);
}
