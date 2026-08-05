package org.blubakery.common.messaging.review;

import org.blubakery.common.messaging.event.BaseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.blubakery.common.messaging.review.ReviewPayload;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ReviewEvent extends BaseEvent<ReviewPayload> {
}
