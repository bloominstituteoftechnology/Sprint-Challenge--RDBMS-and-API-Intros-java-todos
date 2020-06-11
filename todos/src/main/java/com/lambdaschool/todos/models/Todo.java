package com.lambdaschool.todos.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo
{
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long todoid;

	@Column(nullable = false)
	private String description;

	private Date datestarted;

	private boolean completed = false;

	@ManyToOne
	@JoinColumn(name = "userid",
				nullable = false)
	private User user;
}
