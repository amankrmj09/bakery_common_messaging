package org.blubakery.common.messaging.stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockOperationResponsePayload {
    private UUID productId;
    private Boolean success;
    private String message;

}
