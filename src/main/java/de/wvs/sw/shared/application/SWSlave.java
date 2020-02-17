package de.wvs.sw.shared.application;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Marvin Erkes on 17.02.20.
 */
public class SWSlave {

    @Getter
    private UUID uuid;

    @Getter
    @Setter
    private Date lastHeartbeat;

    public SWSlave() {
        this.uuid = UUID.randomUUID();
    }

    public boolean isAlive() {
        return this.lastHeartbeat.getTime() <= new Date().getTime() - 10000;
    }

    public enum Status {
        HEALTHY,
        UNHEALTHY
    }
}
