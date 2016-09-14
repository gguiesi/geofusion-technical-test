package br.com.geofusion.splashpage.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by guiesi on 9/14/16.
 */
@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@Size(min = 2)
	private String question1;
	@NotNull
	private Float question2;
	@NotEmpty
	@Size(min = 2)
	private String question3;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Transient
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public Float getQuestion2() {
		return question2;
	}

	public void setQuestion2(Float question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Question{" +
				"id=" + id +
				", question1='" + question1 + '\'' +
				", question2=" + question2 +
				", question3='" + question3 + '\'' +
				'}';
	}
}
