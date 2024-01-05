package com.example.eventsmicroservice.controller;

import com.example.eventsmicroservice.domain.Event;
import com.example.eventsmicroservice.dto.EmailRequestDTO;
import com.example.eventsmicroservice.dto.EventDTO;
import com.example.eventsmicroservice.dto.SubscriptionDTO;
import com.example.eventsmicroservice.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventContrroller {

    @Autowired
    private EventService eventService;


    @GetMapping
    public List<Event>getAllEvent(){
        return eventService.getAllEVents();
    }
    @GetMapping("/upcoming")
    public List<Event>getUpcommingEvent(){
        return eventService.getUpComingEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventDTO event){
        return eventService.createNewEvent(event);
    }

    @PostMapping("/{eventId}/register")
    public void registerParticipant(@PathVariable String eventId, @RequestBody SubscriptionDTO subscriptionDTO){
        eventService.registerParticipant(eventId, subscriptionDTO.participantEmail());

    }




}
