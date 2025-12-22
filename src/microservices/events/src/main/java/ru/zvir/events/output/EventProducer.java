package ru.zvir.events.output;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.zvir.events.dto.request.MovieDtoRequest;
import ru.zvir.events.dto.request.PaymentDtoRequest;
import ru.zvir.events.dto.request.UserDtoRequest;
import ru.zvir.events.dto.response.EventResponse;

import java.time.LocalDateTime;
import java.util.UUID;

import static ru.zvir.events.Constants.*;
import static ru.zvir.events.dto.EventType.MOVIE;

@Service
@RequiredArgsConstructor
public class EventProducer<T> {
    private final KafkaTemplate<String, T> kafkaTemplate;

    @SneakyThrows
    public EventResponse<T> sendEvent(T dto, Long id) {
        String topic = switch (dto) {
            case MovieDtoRequest ignored -> MOVIE_TOPIC;
            case PaymentDtoRequest ignored -> PAYMENT_TOPIC;
            case UserDtoRequest ignored -> USER_TOPIC;
            default -> throw new RuntimeException("No such DTO: " + dto.getClass());
        };

        kafkaTemplate.send(topic, UUID.randomUUID().toString(), dto).get();

        return EventResponse.<T>builder()
                .status("success")
                .event(EventResponse.Event.<T>builder()
                        .id("%s-%s".formatted(MOVIE, id))
                        .event(MOVIE)
                        .timestamp(LocalDateTime.now())
                        .payload(dto)
                        .build())
                .build();
    }
}
