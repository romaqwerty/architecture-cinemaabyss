package ru.zvir.events.input;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import ru.zvir.events.dto.request.MovieDtoRequest;
import ru.zvir.events.dto.request.PaymentDtoRequest;
import ru.zvir.events.dto.request.UserDtoRequest;

import static ru.zvir.events.Constants.*;

@Service
@Slf4j
public class EventConsumer {
    @KafkaListener(topics = MOVIE_TOPIC)
    public void getMovieEvent(MovieDtoRequest dto,
                              @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        log.info("Key: {}; Movie event: {}", key, dto);
    }

    @KafkaListener(topics = PAYMENT_TOPIC)
    public void getPaymentEvent(PaymentDtoRequest dto,
                                @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        log.info("Key: {}; Payment event: {}", key, dto);
    }

    @KafkaListener(topics = USER_TOPIC)
    public void getUserEvent(UserDtoRequest dto,
                             @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        log.info("Key: {}; User event: {}", key, dto);
    }
}
