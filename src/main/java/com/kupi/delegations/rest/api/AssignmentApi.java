package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.api.request.AssignmentRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.AssignmentDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/frontend/assignments")
public interface AssignmentApi {

    @PostMapping
    AssignmentDTO createAssignment(@RequestBody AssignmentRequest assignmentRequest);

    @GetMapping("/{uuid}")
    AssignmentDTO getAssignment(@PathVariable String uuid);

    @GetMapping
    PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params);

    @PutMapping("/{uuid}")
    AssignmentDTO updateAssignment(@PathVariable String uuid, @RequestBody AssignmentRequest assignmentRequest);

    @DeleteMapping("/{uuid}")
    void deleteAssignment(@PathVariable String uuid);

    @GetMapping("/user")
    PagedResponse<AssignmentDTO> getUserAssignments(BasicPageQueryParams params);
}
