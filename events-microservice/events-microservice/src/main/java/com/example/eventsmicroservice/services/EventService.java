package com.example.eventsmicroservice.services;

import com.example.eventsmicroservice.domain.Event;
import com.example.eventsmicroservice.domain.Subscription;
import com.example.eventsmicroservice.dto.EmailRequestDTO;
import com.example.eventsmicroservice.dto.EventDTO;
import com.example.eventsmicroservice.exception.EventFullException;
import com.example.eventsmicroservice.exception.EventNotFoundException;
import com.example.eventsmicroservice.repository.EventRepository;
import com.example.eventsmicroservice.repository.SubscripitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SubscripitionRepository subscripitionRepository;


    @Autowired
    private EmailServiceClient emailServiceClient;

    public List<Event>getAllEVents(){
        return eventRepository.findAll();
    }

    public List<Event>getUpComingEvents(){
        return eventRepository.findUpComingEvent(LocalDateTime.now());
    }

    public Event createNewEvent(EventDTO eventDTO){
        Event newEvent = new Event(eventDTO);
      return   eventRepository.save(newEvent);

    }
    private Boolean isEventFull(Event event){
        return event.getRegisteredParticipants() >= event.getMaxParticipants();
    }

    public void registerParticipant(String eventId, String participantEmail){
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

         if (isEventFull(event) ){
             throw new EventFullException();
         }

             Subscription subscription = new Subscription(event, participantEmail);
            subscripitionRepository.save(subscription);

            event.setRegisteredParticipants(event.getRegisteredParticipants()+1);
             EmailRequestDTO emailRequestDTO = new EmailRequestDTO(participantEmail,"confirmação de incrição", "você foi incrito com sucesso");
             emailServiceClient.sendEmail(emailRequestDTO);


         }


    }


