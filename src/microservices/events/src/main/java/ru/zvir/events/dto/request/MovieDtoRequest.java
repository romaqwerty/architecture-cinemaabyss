package ru.zvir.events.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieDtoRequest {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("movie_id")
    private Long movieId;
    private String title;
    private String action;
    private Double rating;
    private List<String> genres;
    private String description;
}
