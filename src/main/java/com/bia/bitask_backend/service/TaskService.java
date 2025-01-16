package com.bia.bitask_backend.service;

import com.bia.bitask_backend.common.PageResponse;
import com.bia.bitask_backend.entity.Task;

public interface TaskService {

    void something(Long taskPriorityId);

    void somethingElse();

    PageResponse<Task> pagedResult(final int page, final int size);
    
    void queryByExampleCustomMatching();

    void queryByExampleIgnoringProperties();

    void specificationExample();
}
