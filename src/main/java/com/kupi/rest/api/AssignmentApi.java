package com.kupi.rest.api;

import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.AssignmentDTO;
import com.kupi.rest.dto.BasicPageQueryParams;
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
}
