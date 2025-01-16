package com.bia.bitask_backend.service.impl;

import com.bia.bitask_backend.common.PageResponse;
import com.bia.bitask_backend.entity.Task;
import com.bia.bitask_backend.entity.TaskPriority;
import com.bia.bitask_backend.enumaration.TaskPriorityEnum;
import com.bia.bitask_backend.repository.TaskPriorityRepository;
import com.bia.bitask_backend.repository.TaskRepository;
import com.bia.bitask_backend.representation.TaskRepresentation1;
import com.bia.bitask_backend.service.TaskService;
import java.util.List;
import java.util.Optional;

import com.bia.bitask_backend.spec.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final TaskPriorityRepository taskPriorityRepository;

  public void something(Long taskPriorityId) {

    var tasks = taskRepository.findAllByPriorityId(taskPriorityId);
  }

  public void somethingElse() {
    List<Task> tasks = taskRepository.findAll();
    for (Task task : tasks) {
      task.setTitle(task.getTitle().toUpperCase());
    }
    taskRepository.saveAll(tasks);
    taskRepository.transformTasksTitleToUpperCase();
  }

  @Override
  public PageResponse<Task> pagedResult(final int page, final int size) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "title"));

    Page<Task> pagedResult = taskRepository.findAllByPriorityName("anyPriority", pageable);

    return PageResponse.<Task>builder()
        .content(pagedResult.getContent())
        .totalPages(pagedResult.getTotalPages())
        .totalElemeents(pagedResult.getNumberOfElements())
        .isFirst(pagedResult.isFirst())
        .isLast(pagedResult.isLast())
        .build();
  }

  @Override
  public void queryByExampleCustomMatching() {

    Task task = new Task();

    task.setTitle("<UNK>");

    Optional<TaskPriority> highPriority =
        taskPriorityRepository.findByName(TaskPriorityEnum.HIGH.getName());

    task.setPriority(highPriority.get());

    ExampleMatcher matcher =
        ExampleMatcher.matchingAny()
            .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("priority", ExampleMatcher.GenericPropertyMatchers.exact());

    Example<Task> example = Example.of(task, matcher);

    // the output query
    /*
    select * from task
    where lower(title) like '%<UNK>%'
    and priority = 'HIGH'
     */

    List<Task> tasks = taskRepository.findAll(example);
  }

  @Override
  public void queryByExampleIgnoringProperties() {
    Task task = new Task();
    task.setTitle("<UNK>");

    ExampleMatcher matcher =
        ExampleMatcher.matchingAny()
            .withMatcher(
                "title",
                ExampleMatcher.GenericPropertyMatchers.contains().startsWith().ignoreCase())
            .withIgnorePaths("priority", "description");

    Example<Task> example = Example.of(task, matcher);
    List<Task> tasks = taskRepository.findAll(example);
  }

  @Override
  public void specificationExample() {

    Specification<Task> specification = Specification.where(null);
    specification =
        specification
            .and(TaskSpecification.byTaskTitle("sample"))
            .and(TaskSpecification.byTaskPriority(TaskPriorityEnum.HIGH));

    Specification<Task> spec = buildSpecificationWithAndOperator("sample", TaskPriorityEnum.HIGH);
    List<Task> tasks = taskRepository.findAll(specification);
  }

  private Specification<Task> buildSpecificationWithAndOperator(String title, TaskPriorityEnum priority) {
    Specification<Task> specification = Specification.where(null);

    if (StringUtils.hasLength(title)) {
      specification = specification.and(TaskSpecification.byTaskTitle(title));
    }
    if (priority != null) {
      specification = specification.and(TaskSpecification.byTaskPriority(priority));
    }

    return specification;
  }

  // 1- class (TaskRepresentation1) (id, taskCode, title, description)
  //  2- call the task repository and fetch all the tasks (paged)
  // 3- map the result (loop over the result from the DB, do the mapping, collect, return the result)

public List<TaskRepresentation1> getTasksWithRep1() {
return taskRepository.findAllTasks();
}

}
