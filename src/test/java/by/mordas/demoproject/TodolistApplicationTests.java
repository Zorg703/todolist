package by.mordas.demoproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import by.mordas.demoproject.entity.Task;
import by.mordas.demoproject.repository.TasksRepository;
import by.mordas.demoproject.util.CurrentDate;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
public class TodolistApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TasksRepository repo;
	
	@Test
	public void whenFindByText_thenReturnTask() {
		LocalDateTime creation=CurrentDate.getCurrentDate();
		LocalDateTime end=CurrentDate.getCurrentDate();
		Task task=new Task("Hello",creation,end);
		entityManager.persist(task);
		entityManager.flush();
		
		Task found=repo.findByDescription("Hello");
		assertThat(found.getDescription())
		 .isEqualTo(task.getDescription());
	}
	

}
