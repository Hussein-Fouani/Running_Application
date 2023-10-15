package com.hf.running_application.services;

import com.hf.running_application.model.ClubDTO;
import com.hf.running_application.model.EventDTO;

import java.util.List;

public interface EventService {

    void CreateEvent(Long eventId, EventDTO event);

    List<EventDTO> findallEvents();

    EventDTO findeventById(Long eventId);

    void updateEvents(EventDTO eventdto);

    void deleteEvent(Long eventId);
}
