package com.bia.bitask_backend.repository;

import com.bia.bitask_backend.entity.Task;
import com.bia.bitask_backend.entity.TaskPriority;
import com.bia.bitask_backend.representation.TaskRepresentation1;
import com.bia.bitask_backend.representation.TaskRepresentation2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

  List<Task> findAllByPriority(TaskPriority taskPriority);

  List<Task> findAllByPriorityId(Long taskPriorityId);

  // find all the tasks where the name equals 'HIGH'
  /*
   select t.* from TaskPriority tp
   inner join task t on t.priority_id = t.id
   where tp.name = 'HIGH'
  */
  List<Task> findAllByPriorityName(String priorityName);


  Page<Task> findAllByPriorityName(String priorityName, Pageable pageable);

  @Query(
      """
Select t from Task t
INNER JOIN TaskPriority tp ON t.priority.id = tp.id
WHERE tp.name LIKE :priorityName
""")
  List<Task> findAllByPriority(@Param("priorityName") String priorityName);

  @Query(
      """
UPDATE Task SET title = upper(title)
""")
  @Modifying
  void transformTasksTitleToUpperCase();

  @Query(
      """
select t.id, t.taskCode, t.title, t.description from Task t
""")
  List<TaskRepresentation1> findAllTasks();

  @Query(
      """
select t.taskCode, t.title, t.priority.name AS taskPriority from Task t""")
  List<TaskRepresentation2> findAllTasks2();
}
