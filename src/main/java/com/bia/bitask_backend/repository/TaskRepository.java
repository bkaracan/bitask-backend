package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.Task;
import com.bia.bitask_backend.entity.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  List<Task> findAllByPriority(TaskPriority taskPriority);

  List<Task> findAllByPriorityId(Long taskPriorityId);

  List<Task> findAllByPriorityName(String priorityName);

  @Query(
      """
Select t from Task t
INNER JOIN TaskPriority tp ON t.priority.id = tp.id
WHERE tp.name LIKE :priorityName
""")
  List<Task> findAllByPriority(@Param("priorityName") String priorityName);
}
