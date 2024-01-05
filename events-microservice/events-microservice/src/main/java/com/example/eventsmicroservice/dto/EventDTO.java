package com.example.eventsmicroservice.dto;

public record EventDTO(int maxParticipants, int registeredParticipants, String date, String title, String description) {
}
