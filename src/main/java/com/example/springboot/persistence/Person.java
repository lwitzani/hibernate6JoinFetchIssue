package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BaseEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person extends BaseEntity {
    private Set<Leg> legs = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Leg> getLegs() {
        return legs;
    }
}
