package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.model.request.VoteCastingRequest;
import com.alpergayretoglu.online_student_election.model.response.ElectionResponse;
import com.alpergayretoglu.online_student_election.model.response.ElectionResultResponse;
import com.alpergayretoglu.online_student_election.model.response.MessageResponse;
import com.alpergayretoglu.online_student_election.model.response.UserResponse;
import com.alpergayretoglu.online_student_election.service.ElectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/election")
@AllArgsConstructor
@CrossOrigin
public class ElectionController {

    private ElectionService electionService;

    @GetMapping
    public List<ElectionResponse> listElections() {
        return electionService.listElections().stream().map(ElectionResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("{electionId}")
    public ElectionResponse getElection(@PathVariable String electionId) {
        return ElectionResponse.fromEntity(electionService.getElection(electionId));
    }

    @PostMapping
    public ElectionResponse addElection(@Valid @RequestBody ElectionCreateRequest request) {
        return ElectionResponse.fromEntity(electionService.addElection(request));
    }

    @PutMapping("{electionId}")
    public ElectionResponse updateElection(@PathVariable String electionId, @Valid @RequestBody ElectionUpdateRequest request) {
        return ElectionResponse.fromEntity(electionService.updateElection(electionId, request));
    }

    @DeleteMapping("{electionId}")
    public void deleteElection(@PathVariable String electionId) {
        electionService.deleteElection(electionId);
    }


    @PutMapping("{electionId}/end")
    public MessageResponse endElection(@PathVariable String electionId) {
        return electionService.endElection(electionId);
    }

    @GetMapping("{electionId}/candidates")
    public List<UserResponse> getCandidates(@PathVariable String electionId) {
        return electionService.getCandidates(electionId).stream().map(UserResponse::fromEntity).collect(Collectors.toList());
    }

    @PostMapping("cast-vote/{voterId}")
    public MessageResponse castVote(@PathVariable String voterId, @Valid @RequestBody VoteCastingRequest voteCastingRequest) {
        return electionService.castVote(voterId, voteCastingRequest);
    }

    @GetMapping("/finished")
    public List<ElectionResponse> getAllFinishedElections() {
        return electionService.getAllFinishedElections().stream().map(ElectionResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/ongoing")
    public List<ElectionResponse> getAllOngoingElections() {
        return electionService.getAllOngoingElections().stream().map(ElectionResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/upcoming")
    public List<ElectionResponse> getAllUpcomingElections() {
        return electionService.getAllUpcomingElections().stream().map(ElectionResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/current_term_results")
    public List<ElectionResultResponse> getElectionResultsForCurrentTerm() {
        return electionService.getAllElectionsForCurrentTerm().stream().map(ElectionResultResponse::fromEntity).collect(Collectors.toList());
    }

}
