package com.kupi.service;

import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.AssignmentDTO;
import com.kupi.rest.dto.BasicPageQueryParams;

/**
 * Service interface for managing assignments in the system.
 */
public interface AssignmentService {

    /**
     * Saves an assignment to the system.
     *
     * @param assignmentRequest request to create an assignment
     * @return created assignment representation
     */
    AssignmentDTO createAssignment(AssignmentRequest assignmentRequest);

    /**
     * Returns an assignment with the provided UUID.
     *
     * @param uuid UUID of the assignment
     * @return assignment representation
     */
    AssignmentDTO getAssignment(String uuid);

    /**
     * Pages through the assignments.
     *
     * @param params query parameters for pagination
     * @return paginated list of assignments
     */
    PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params);

    /**
     * Updates an assignment with the provided UUID.
     *
     * @param uuid                 assignment UUID
     * @param assignmentRequest request to update an assignment
     * @return updated assignment representation
     */
    AssignmentDTO updateAssignment(String uuid, AssignmentRequest assignmentRequest);

    /**
     * Deletes an assignment with the provided UUID.
     *
     * @param uuid assignment UUID
     */
    void deleteAssignment(String uuid);
}
