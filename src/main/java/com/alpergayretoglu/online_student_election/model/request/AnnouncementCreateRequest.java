package com.alpergayretoglu.online_student_election.model.request;

import com.alpergayretoglu.online_student_election.model.entity.Announcement;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class AnnouncementCreateRequest {
    private String title;
    private String content;

    public static Announcement toEntity(AnnouncementCreateRequest request) {
        return Announcement.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .date(LocalDateTime.now())
                .build();
    }
}
