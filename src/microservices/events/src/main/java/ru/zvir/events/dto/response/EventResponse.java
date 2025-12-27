package ru.zvir.events.dto.response;

import lombok.Builder;
import lombok.Data;
import ru.zvir.events.dto.EventType;

import java.time.LocalDateTime;


@Data
@Builder
public class EventResponse<T> {
    private String status;
    private Event<T> event;

    @Data
    @Builder
    public static class Event<T> {
       private String id;
       private EventType event;
       private LocalDateTime timestamp;
       private T payload;
    }
}
