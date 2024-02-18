package com.kupi.rest.api;

import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.AssignmentDTO;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.service.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentApiImpl implements AssignmentApi {

    private static Logger log = LoggerFactory.getLogger(AssignmentApiImpl.class);

    private final AssignmentService assignmentService;

    public AssignmentApiImpl(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentRequest assignmentRequest) {
        log.info("AssignmentApi.createAssignment [{}]", assignmentRequest);
        return assignmentService.saveAssignment(assignmentRequest);
    }

    @Override
    public AssignmentDTO getAssignment(String uuid) {
        log.info("AssignmentApi.getAssignment [{}]", uuid);
        return assignmentService.getAssignment(uuid);
    }

    @Override
    public PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params) {
        log.info("AssignmentApi.getAssignments [{}]", params);
        return assignmentService.getAssignments(params);
    }

    @Override
    public AssignmentDTO updateAssignment(String uuid, AssignmentRequest assignmentRequest) {
        log.info("AssignmentApi.updateAssignment [{}, {}]", uuid, assignmentRequest);
        return assignmentService.updateAssignment(uuid, assignmentRequest);
    }

    @Override
    public void deleteAssignment(String uuid) {
        log.info("AssignmentApi.deleteAssignment [{}]", uuid);
        assignmentService.deleteAssignment(uuid);
    }
}
