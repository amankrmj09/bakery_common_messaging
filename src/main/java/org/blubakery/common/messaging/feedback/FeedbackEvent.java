package org.blubakery.common.messaging.feedback;

import org.blubakery.common.messaging.event.BaseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.blubakery.common.messaging.feedback.FeedbackPayload;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class FeedbackEvent extends BaseEvent<FeedbackPayload> {
}
