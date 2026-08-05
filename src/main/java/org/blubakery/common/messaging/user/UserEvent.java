package org.blubakery.common.messaging.user;

import org.blubakery.common.messaging.event.BaseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.blubakery.common.messaging.user.UserPayload;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class UserEvent extends BaseEvent<UserPayload> {
}
