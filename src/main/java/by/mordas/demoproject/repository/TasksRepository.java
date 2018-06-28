package by.mordas.demoproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.mordas.demoproject.entity.Task;

@Repository
public interface TasksRepository extends CrudRepository<Task, Long>{
	Task findByDescription(String description);
}
