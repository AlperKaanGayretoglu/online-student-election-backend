package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.model.entity.Announcement;
import com.alpergayretoglu.online_student_election.model.request.AnnouncementCreateRequest;
import com.alpergayretoglu.online_student_election.model.response.MessageResponse;
import com.alpergayretoglu.online_student_election.repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<Announcement> listAnnouncements() {
        List<Announcement> announcements = new ArrayList<>(announcementRepository.findAll());
        announcements.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return announcements;
    }

    public MessageResponse addAnnouncement(AnnouncementCreateRequest request) {
        announcementRepository.save(AnnouncementCreateRequest.toEntity(request));
        return new MessageResponse(ApplicationMessages.ANNOUNCEMENT_ADD_SUCCESS, true);
    }

}
