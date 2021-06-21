package br.edu.infnet.springsecurity.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "animes")
public class Anime {

    @JsonIgnoreProperties

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public int mal_id;

    private String title;

    private String synopsis;

    private int episodes;

    private int score;

    private String image_url;

    private String userEmail;

    public Anime() {
    }

    public Anime(int mal_id, String title, String synopsis, int episodes, int score, String image_url,
            String userEmail) {
        this.mal_id = mal_id;
        this.title = title;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
        this.image_url = image_url;
        this.userEmail = userEmail;
    }

    public Anime(String title, String synopsis, int episodes, int score, String image_url, String userEmail) {
        this.title = title;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
        this.image_url = image_url;
        this.userEmail = userEmail;
    }

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
