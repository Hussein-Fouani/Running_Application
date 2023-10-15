package com.hf.running_application.repository;

import com.hf.running_application.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventRepository extends JpaRepository<Event,Long> {
}
