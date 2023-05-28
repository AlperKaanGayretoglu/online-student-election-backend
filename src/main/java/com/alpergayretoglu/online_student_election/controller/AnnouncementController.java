package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.AnnouncementCreateRequest;
import com.alpergayretoglu.online_student_election.model.response.AnnouncementResponse;
import com.alpergayretoglu.online_student_election.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
@CrossOrigin
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping
    public List<AnnouncementResponse> listAnnouncements() {
        return announcementService.listAnnouncements().stream().map(AnnouncementResponse::fromEntity).collect(Collectors.toList());
    }

    @PostMapping
    public String addAnnouncement(@Valid @RequestBody AnnouncementCreateRequest request) {
        return announcementService.addAnnouncement(request);
    }
}
