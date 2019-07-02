package com.example.postgistest.Logs.repositories;


import com.example.postgistest.Logs.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Logs, Long> {

    Optional<Logs> findById(Long id);
    Optional<Logs> findByJobId(Long jobId);


    @Query("SELECT id from Logs")
    List<Long> getLogIds();
}
