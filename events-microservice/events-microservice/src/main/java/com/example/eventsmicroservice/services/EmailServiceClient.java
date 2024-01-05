package com.example.eventsmicroservice.services;

import com.example.eventsmicroservice.dto.EmailRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "email-service", url = "http://localhost:8080/event/id/register")
public interface EmailServiceClient {
    @PostMapping("/send")
     void sendEmail(@RequestBody EmailRequestDTO emailRequest);
}
