package by.mordas.demoproject.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.mordas.demoproject.entity.Task;
import by.mordas.demoproject.repository.TasksRepository;
import by.mordas.demoproject.util.CurrentDate;
import by.mordas.demoproject.util.DateTimeConverter;

@Controller
public class MainController {
	@Autowired
	private final TasksRepository repository;
	
	public MainController(TasksRepository repository) {
		this.repository=repository;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/tasks")
	public String tasks(Map<String,Object> model) {
		Iterable<Task> tasks=repository.findAll();
		model.put("tasks", tasks);
		return "tasks";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/form")
	public String add(Map<String,Object> model,@RequestParam String description,@RequestParam String deadLine) {
		LocalDateTime creationDate=CurrentDate.getCurrentDate();
		LocalDateTime endDate=DateTimeConverter.getLocaleDateTime(deadLine);
		Task task=new Task(description, creationDate,endDate );
		repository.save(task);
		return "success";
	}
	

}
