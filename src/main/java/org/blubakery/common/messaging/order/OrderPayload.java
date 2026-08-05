package org.blubakery.common.messaging.order;

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
public class OrderPayload {
    private UUID orderId;
    private String orderNumber;
    private UUID userId;
    private String customerEmail;
    private BigDecimal totalAmount;
    private String status; // PENDING, CONFIRMED, CANCELLED, DELIVERED, etc.
    private String invoiceUrl;
    private String deliveryAddress;
    private String cancellationReason;
    private LocalDateTime timestamp;
    private Boolean cancelledByAdmin;
}
