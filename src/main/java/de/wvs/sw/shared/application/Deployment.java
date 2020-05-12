package de.wvs.sw.shared.application;

import de.progme.athena.db.serialization.annotation.Column;
import de.progme.athena.db.serialization.annotation.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marvin Erkes on 17.02.20.
 */
@Table(name = "sw_deployments", options = { Table.Option.CREATE_IF_NOT_EXISTS })
public class Deployment {

    @Column(name = "id", options = { Column.Option.PRIMARY_KEY, Column.Option.AUTO_INCREMENT })
    @Getter
    private int id;

    @Column(name = "uuid")
    @Getter
    private String uuid;

    @Column(name = "application")
    @Getter @Setter
    private int application;
    @Getter @Setter
    private Application applicationRef;

    @Column(name = "slave")
    @Getter @Setter
    private String slave;

    @Column(name = "status")
    private int status;

    @Column(name = "utilization")
    private int usage;

    @Column(name = "host")
    @Getter
    @Setter
    private String host;

    @Column(name = "port")
    @Getter
    @Setter
    private int port;

    @Getter @Setter
    private Process process;

    public Deployment() {

    }

    public Deployment(int id, String uuid, int application, String slave, int status, int usage, String host, int port) {

        this.id = id;
        this.uuid = uuid;
        this.application = application;
        this.slave = slave;
        this.status = status;
        this.usage = usage;
        this.host = host;
        this.port = port;
    }

    public Deployment(int id, String uuid, int application, String slave, Status status, Usage usage, String host, int port) {

        this(id, uuid, application, slave, status.getValue(), usage.getValue(), host, port);
    }

    public Status getStatus() {
        return Status.valueOf(this.status);
    }
    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public Status getUsage() {
        return Status.valueOf(this.usage);
    }
    public void setUsage(Usage usage) {
        this.usage = usage.getValue();
    }

    public enum Status {
        WAITING(0),
        STARTING(1),
        RUNNING(2),
        TERMINATING(3),
        TERMINATED(4);

        private int value;
        private static Map<Integer, Status> map = new HashMap<>();

        Status(int value) {
            this.value = value;
        }

        static {
            for (Status status : Status.values()) {
                map.put(status.value, status);
            }
        }

        public static Status valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    public enum Usage {
        LOW(0),
        MEDIUM(1),
        HEAVY(2);

        private int value;
        private static Map<Integer, Usage> map = new HashMap<>();

        Usage(int value) {
            this.value = value;
        }

        static {
            for (Usage usage : Usage.values()) {
                map.put(usage.value, usage);
            }
        }

        public static Usage valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }
}
