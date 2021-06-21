package br.edu.infnet.springsecurity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimeAux {

    @JsonProperty("mal_id")
    private int mal_id;

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @JsonProperty("title")
    private String title;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("episodes")
    private int episodes;

    @JsonProperty("score")
    private int score;

    @JsonProperty("image_url")
    private String image_url;

}
