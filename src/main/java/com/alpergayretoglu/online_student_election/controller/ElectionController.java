package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.model.response.ElectionResponse;
import com.alpergayretoglu.online_student_election.service.ElectionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election")
@AllArgsConstructor
public class ElectionController {

    private ElectionService ElectionService;

    @GetMapping
    public List<ElectionResponse> getElections() {
        return ElectionService.getElections().stream().map(ElectionResponse::fromEntity).toList();
    }

    @GetMapping("{electionId}")
    public ElectionResponse getElection(@PathVariable String electionId) {
        return ElectionResponse.fromEntity(ElectionService.getElection(electionId));
    }

    @PostMapping
    public ElectionResponse addElection(@Valid @RequestBody ElectionCreateRequest request) {
        return ElectionResponse.fromEntity(ElectionService.addElection(request));
    }

    @PutMapping("{electionId}")
    public ElectionResponse updateElection(@PathVariable String electionId, @Valid @RequestBody ElectionUpdateRequest request) {
        return ElectionResponse.fromEntity(ElectionService.updateElection(electionId, request));
    }

    @DeleteMapping("{electionId}")
    public void deleteElection(@PathVariable String electionId) {
        ElectionService.deleteElection(electionId);
    }
}
