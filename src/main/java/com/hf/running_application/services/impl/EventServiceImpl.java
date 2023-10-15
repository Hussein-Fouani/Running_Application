package com.hf.running_application.services.impl;

import com.hf.running_application.entities.Club;
import com.hf.running_application.entities.Event;
import com.hf.running_application.exceptions.ClubNotFoundException;
import com.hf.running_application.exceptions.EventNotFounException;
import com.hf.running_application.model.EventDTO;
import com.hf.running_application.repository.clubrepository;
import com.hf.running_application.repository.eventRepository;
import com.hf.running_application.services.EventService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.hf.running_application.mappers.EventMapper.mapToEvent;
import static com.hf.running_application.mappers.EventMapper.mapToEventDTO;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private eventRepository repository;
    private clubrepository repo;
    private final ModelMapper modelMapper;

    @Override
    public void CreateEvent(Long clubId, EventDTO event) {
        Club club = repo.findById(clubId).orElseThrow(()-> new ClubNotFoundException("Club Not Found",clubId));
        Event event1 =mapToEvent(event);
        event1.setClub(club);
        repository.save(event1);
    }

    @Override
    public List<EventDTO> findallEvents() {
        return repository.findAll().stream().map((element) -> modelMapper.map(element, EventDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EventDTO findeventById(Long eventId) {
      Event event =   repository.findById(eventId).orElseThrow(()-> new EventNotFounException("Event not Found ",eventId));
      return mapToEventDTO(event);
    }

    @Override
    public void updateEvents(EventDTO eventdto) {
        Event event = mapToEvent(eventdto);
        repository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        repository.deleteById(eventId);
    }


}
