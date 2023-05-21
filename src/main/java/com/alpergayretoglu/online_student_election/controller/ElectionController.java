package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.model.request.VoteCastingRequest;
import com.alpergayretoglu.online_student_election.model.response.ElectionResponse;
import com.alpergayretoglu.online_student_election.model.response.ElectionResultResponse;
import com.alpergayretoglu.online_student_election.service.ElectionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election")
@AllArgsConstructor
@CrossOrigin
public class ElectionController {

    private ElectionService electionService;

    @GetMapping
    public List<ElectionResponse> listElections() {
        return electionService.getElections().stream().map(ElectionResponse::fromEntity).toList();
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
    public String endElection(@PathVariable String electionId) {
        return electionService.endElection(electionId);
    }

    @PostMapping("{electionId}/cast-vote")
    public String castVote(@PathVariable String electionId, VoteCastingRequest voteCastingRequest) {
        return electionService.castVote(electionId, voteCastingRequest);
    }

    @GetMapping("/current_term")
    public List<ElectionResponse> getAllElectionsForCurrentTerm() {
        return electionService.getAllElectionsForCurrentTerm().stream().map(ElectionResponse::fromEntity).toList();
    }

    @GetMapping("/current_term_results")
    public List<ElectionResultResponse> getElectionResultsForCurrentTerm() {
        return electionService.getAllElectionsForCurrentTerm().stream().map(ElectionResultResponse::fromEntity).toList();
    }

}
