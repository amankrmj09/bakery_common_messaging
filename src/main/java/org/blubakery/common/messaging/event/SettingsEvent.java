package org.blubakery.common.messaging.event;

import org.blubakery.common.messaging.contract.messaging.SettingsPayload;

public class SettingsEvent extends BaseEvent<SettingsPayload> {
    public SettingsEvent() {
        super();
        this.setEventType("SettingsEvent");
    }
    public SettingsEvent(SettingsPayload payload) {
        super();
        this.setEventType("SettingsEvent");
        this.setPayload(payload);
    }
}
