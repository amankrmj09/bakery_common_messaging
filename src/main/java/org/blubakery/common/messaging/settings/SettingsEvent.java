package org.blubakery.common.messaging.settings;

import org.blubakery.common.messaging.event.BaseEvent;

import org.blubakery.common.messaging.settings.SettingsPayload;

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
