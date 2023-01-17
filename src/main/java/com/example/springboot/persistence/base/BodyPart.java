package com.example.springboot.persistence.base;

import com.example.springboot.persistence.NestedEntity;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
@Table(name = "body_part")
public abstract class BodyPart extends BaseEntity {
    protected NestedEntity nestedEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public NestedEntity getNestedEntity() {
        return nestedEntity;
    }
}
