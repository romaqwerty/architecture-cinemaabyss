package ru.zvir.events.input;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zvir.events.dto.request.MovieDtoRequest;
import ru.zvir.events.dto.request.PaymentDtoRequest;
import ru.zvir.events.dto.request.UserDtoRequest;
import ru.zvir.events.dto.response.EventResponse;
import ru.zvir.events.output.EventProducer;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class Controller {
    private final EventProducer<MovieDtoRequest> movieService;
    private final EventProducer<PaymentDtoRequest> paymentService;
    private final EventProducer<UserDtoRequest> userService;

    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse<MovieDtoRequest> createMessage(@RequestBody MovieDtoRequest dto) {
        return movieService.sendEvent(dto, dto
                .getMovieId());
    }


    @PostMapping(value = "/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse<PaymentDtoRequest> createMessage(@RequestBody PaymentDtoRequest dto) {
        return paymentService.sendEvent(dto, dto.getPaymentId());
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse<UserDtoRequest> createMessage(@RequestBody UserDtoRequest dto) {
        return userService.sendEvent(dto, dto.getUserId());
    }

    @GetMapping(value = "/health")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Boolean>> getHealth() {
        return ResponseEntity.ok().body(Map.of("status", true));
    }
}
