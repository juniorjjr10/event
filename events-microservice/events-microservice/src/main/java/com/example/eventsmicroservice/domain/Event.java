package com.example.eventsmicroservice.domain;

import com.example.eventsmicroservice.dto.EventDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxParticipants;
    private int registeredParticipants;
    private String data;
    private String title;
    private String descripition;

    public Event(EventDTO eventDTO) {
        this.maxParticipants = eventDTO.maxParticipants();
        this.registeredParticipants = eventDTO.registeredParticipants();
        this.data = eventDTO.date();
        this.title = eventDTO.title();
        this.descripition = eventDTO.description();
    }
}
