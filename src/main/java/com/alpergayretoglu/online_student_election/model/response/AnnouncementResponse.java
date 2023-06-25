package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Announcement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementResponse {
    private String title;
    private String content;
    private ZonedDateTime date;

    public static AnnouncementResponse fromEntity(Announcement announcement) {
        return AnnouncementResponse.builder()
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .date(announcement.getDate())
                .build();
    }
}
