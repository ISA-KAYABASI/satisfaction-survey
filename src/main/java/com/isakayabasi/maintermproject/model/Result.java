package com.isakayabasi.maintermproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "Result")
public class Result extends TimeStampModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "total_Correct")
	private double totalCorrect = 0;
	@Column(name = "Satisfaction")
	private String satisfaction;
	@Column(name = "message_id")
	private String messageId;
	@Column(name = "user_name")
	private String username;
	@Column(name = "email_id")
	private String email;






}
