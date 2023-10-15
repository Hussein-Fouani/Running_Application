package com.hf.running_application.repository;

import com.hf.running_application.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface clubrepository extends JpaRepository<Club,Long> {

    Optional<Club> findByTitle(String string);
    @Query("select c from Club c where c.title like concat('%',:query,'%') ")
    List<Club> searchClubs(String query);

}
