package com.isakayabasi.maintermproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quesId;
	private String title;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String optionE;
	private int ans1;
	private int ans2;
	private int ans3;
	private int ans4;
	private int ans5;
	private int chose;
}
