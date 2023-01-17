package com.example.springboot.persistence.base;

import javax.persistence.*;
import lombok.Setter;

@Setter
@MappedSuperclass
public abstract class BaseEntity {
    protected long id;
    protected String name;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hibernate_sequence"
    )

    @SequenceGenerator(
            name = "hibernate_sequence",
            sequenceName = "hibernate_sequence",
            allocationSize = 1
    )
    @Column(name = "id")
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
}
