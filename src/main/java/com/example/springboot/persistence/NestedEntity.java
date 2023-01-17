package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BaseEntity;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class NestedEntity extends BaseEntity {

    public NestedEntity(String name) {
        this.name = name;
    }
}
