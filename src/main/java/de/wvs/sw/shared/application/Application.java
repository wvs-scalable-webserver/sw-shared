package de.wvs.sw.shared.application;

import de.progme.athena.db.serialization.annotation.Column;
import de.progme.athena.db.serialization.annotation.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Marvin Erkes on 17.02.20.
 */
@Table(name = "sw_applications", options = { Table.Option.CREATE_IF_NOT_EXISTS })
public class Application {

    @Column(name = "id", options = { Column.Option.PRIMARY_KEY, Column.Option.AUTO_INCREMENT })
    @Getter
    private int id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "minimum")
    @Getter @Setter
    private int minimum;

    @Column(name = "maximum")
    @Getter @Setter
    private int maximum;

    public Application() {

    }

    public Application(int id, String name, int minimum, int maximum) {

        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
