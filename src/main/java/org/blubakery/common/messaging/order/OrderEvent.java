package org.blubakery.common.messaging.order;

import org.blubakery.common.messaging.event.BaseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.blubakery.common.messaging.order.OrderPayload;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class OrderEvent extends BaseEvent<OrderPayload> {
}
