package br.edu.infnet.springsecurity.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RetornoApi {

    @JsonProperty("results")
    public List<AnimeAux> results;

}
