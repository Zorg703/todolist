package by.mordas.demoproject.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String description;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime deadLine;
	
	
	
	/**
	 * 
	 */
	public Task() {
		super();
	}
	/**
	 * @param description
	 * @param creationDate
	 * @param deadLine
	 */
	public Task(String description, LocalDateTime creationDate, LocalDateTime deadLine) {
		super();
		this.description = description;
		this.creationDate = creationDate;
		this.deadLine = deadLine;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the deadLine
	 */
	public LocalDateTime getDeadLine() {
		return deadLine;
	}
	/**
	 * @param deadLine the deadLine to set
	 */
	public void setDeadLine(LocalDateTime deadLine) {
		this.deadLine = deadLine;
	}
	
	
}
