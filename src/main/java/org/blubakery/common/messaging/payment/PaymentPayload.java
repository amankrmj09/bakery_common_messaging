package org.blubakery.common.messaging.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPayload {
    private UUID paymentId;
    private UUID orderId;
    private UUID userId;
    private String customerEmail;
    private String status; // SUCCESS, FAILED, REFUNDED
    private BigDecimal amount;
    private BigDecimal refundAmount;
    private String refundReason;
    private LocalDateTime timestamp;
    private String customerPhone;
}
