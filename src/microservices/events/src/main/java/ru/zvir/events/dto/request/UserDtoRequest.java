package ru.zvir.events.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDtoRequest {
    @JsonProperty("user_id")
    private Long userId;
    private String action;
    private LocalDateTime timestamp;
    private String username;
    private String email;
}
