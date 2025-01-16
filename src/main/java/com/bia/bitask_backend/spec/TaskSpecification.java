package com.bia.bitask_backend.spec;

import com.bia.bitask_backend.entity.Task;
import com.bia.bitask_backend.enumaration.TaskPriorityEnum;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

  public static Specification<Task> byTaskTitle(String taskTitle) {
    return ((root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get("title"), taskTitle));
  }

  public static Specification<Task> byTaskPriority(TaskPriorityEnum... taskPriority) {
      return ((root, query, criteriaBuilder) ->
              criteriaBuilder.equal(root.get("priority"), taskPriority));
  }

  public static Specification<Task> byTaskCode(String taskCode) {
      return ((root, query, criteriaBuilder) ->
              criteriaBuilder.equal(root.get("code"), taskCode));
  }
}
