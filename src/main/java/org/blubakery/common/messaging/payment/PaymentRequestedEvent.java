package org.blubakery.common.messaging.payment;

import org.blubakery.common.messaging.event.BaseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.blubakery.common.messaging.payment.PaymentRequestedPayload;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class PaymentRequestedEvent extends BaseEvent<PaymentRequestedPayload> {
}
