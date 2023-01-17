package com.example.springboot.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select person " +
            "from Person person " +
            "left join fetch person.legs as leg " +
            "left join fetch leg.nestedEntity " +
            "where person.id = :id")
    Person findByIdJoinFetchLegsWithNestedEntity(@Param("id") Long id);
}
