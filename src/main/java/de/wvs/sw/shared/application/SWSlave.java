package de.wvs.sw.shared.application;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Marvin Erkes on 17.02.20.
 */
public class SWSlave {

    @Getter
    private UUID uuid;

    @Getter
    @Setter
    private Status status;

    @Getter
    @Setter
    private Date lastHeartbeat;

    @Getter
    private String host;

    @Getter
    private final int minPort;

    @Getter
    private final int maxPort;

    public SWSlave(UUID uuid, Status status, String host, int minPort, int maxPort) {
        this.uuid = uuid;
        this.status = status;
        this.host = host;
        this.minPort = minPort;
        this.maxPort = maxPort;
    }

    public SWSlave(UUID uuid, Status status, String host) {
        this(uuid, status, host, 0, 0);
    }

    public SWSlave(String host, int minPort, int maxPort) {
        this(UUID.randomUUID(), Status.HEALTHY, host, minPort, maxPort);
    }

    public boolean isAlive() {
        return this.lastHeartbeat.getTime() >= new Date().getTime() - 10000;
    }

    public enum Status {
        HEALTHY,
        UNHEALTHY
    }
}
