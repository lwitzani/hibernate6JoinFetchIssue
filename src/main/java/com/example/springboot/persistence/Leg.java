package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BodyPart;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@DiscriminatorValue("LegBodyPart")
public class Leg extends BodyPart {
    protected Person person;

    public Leg(String name, Person person, NestedEntity nestedEntity) {
        this.name = name;
        this.person = person;
        this.nestedEntity = nestedEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Person getPerson() {
        return person;
    }
}
