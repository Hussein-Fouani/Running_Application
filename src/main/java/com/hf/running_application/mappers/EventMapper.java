package com.hf.running_application.mappers;

import com.hf.running_application.entities.Event;
import com.hf.running_application.model.EventDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
public class EventMapper {
    private static ModelMapper modelMapper;
    public static Event mapToEvent(EventDTO eventDTO){
      return modelMapper.map(eventDTO,Event.class);

    }
    public static EventDTO mapToEventDTO(Event event){
        return modelMapper.map(event,EventDTO.class);
    }
}
