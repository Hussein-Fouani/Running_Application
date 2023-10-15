package com.hf.running_application.controllers;

import com.hf.running_application.entities.Event;
import com.hf.running_application.model.ClubDTO;
import com.hf.running_application.model.EventDTO;
import com.hf.running_application.services.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@AllArgsConstructor
@Controller
public class EventController {
    private EventService eventService;

    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDTO> events = eventService.findallEvents();
        model.addAttribute("events",events);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable Long eventId,Model model){
       EventDTO dto= eventService.findeventById(eventId);
       model.addAttribute("events",dto);
       return "events-detail";
    }

    @GetMapping("/events/{clubId}/new")
    public String createEvent(@PathVariable Long clubId, Model model){
        Event event = new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "events-create";
    }
    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId,Model model){
        EventDTO eventDTO= eventService.findeventById(eventId);
        model.addAttribute("event",eventDTO);
        return "events-edit";
    }


    @PostMapping("/events/{clubId")
    public String createEvents(@PathVariable Long clubId, @ModelAttribute("event") EventDTO eventDTO,Model model){
        eventService.CreateEvent(clubId,eventDTO);
        return "redirect:/clubs" + clubId;

    } @PostMapping("/{eventId}/edit")
    public String updateEvent(@PathVariable Long eventId, @Valid @ModelAttribute("event") EventDTO eventdto,Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("event",eventdto);
            return "events-edit";
        }
        EventDTO eventDTO =eventService.findeventById(eventId);
        eventDTO.setClub(eventDTO.getClub());
        eventdto.setId(eventId);
        eventService.updateEvents(eventdto);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable Long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events-list";
    }

}
