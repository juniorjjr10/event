package com.example.eventsmicroservice.repository;

import com.example.eventsmicroservice.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscripitionRepository extends JpaRepository<Subscription, Long> {
}
