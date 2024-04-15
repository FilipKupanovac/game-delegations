package com.kupi.rest.api;

import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v1/frontend/competitions")
public interface CompetitionApi {

    @PostMapping
    CompetitionDTO createCompetition(@RequestBody CompetitionRequest competitionRequest);

    @GetMapping("/{uuid}")
    CompetitionDTO getCompetition(@PathVariable String uuid);

    @GetMapping
    PagedResponse<CompetitionDTO> getAllCompetitions(@RequestParam("params") BasicPageQueryParams params);

    @PutMapping("/{uuid}")
    CompetitionDTO updateCompetition(@PathVariable String uuid, @RequestBody CompetitionRequest competitionRequest);

    @DeleteMapping("/{uuid}")
    void deleteCompetition(@PathVariable String uuid);
}
