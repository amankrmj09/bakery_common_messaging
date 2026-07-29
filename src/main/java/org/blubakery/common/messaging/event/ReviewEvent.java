package org.blubakery.common.messaging.event;

import org.blubakery.common.messaging.contract.messaging.ReviewPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ReviewEvent extends BaseEvent<ReviewPayload> {
}
