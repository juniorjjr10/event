package com.example.eventsmicroservice.repository;

import com.example.eventsmicroservice.domain.Event;
import feign.Param;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM events e WHERE PARSEDATETIME(e.date AS' dd/MM/yyyy') > :currentDate",nativeQuery = true)
    List<Event> findUpComingEvent(@Param("currentDate")LocalDateTime currentDate);

    @Nonnull
    Optional<Event> findById(@Nonnull String id);
}
