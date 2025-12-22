package ru.zvir.events.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDtoRequest {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("payment_id")
    private Long paymentId;
    @JsonProperty("method_type")
    private String methodType;
    private Double amount;
    private String status;
    private LocalDateTime timestamp;
}
