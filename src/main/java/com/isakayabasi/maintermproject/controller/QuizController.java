package com.isakayabasi.maintermproject.controller;

import com.isakayabasi.maintermproject.model.QuestionForm;
import com.isakayabasi.maintermproject.model.Result;
import com.isakayabasi.maintermproject.model.User;
import com.isakayabasi.maintermproject.repository.IUserRepository;
import com.isakayabasi.maintermproject.repository.ResultRepo;
import com.isakayabasi.maintermproject.service.Service.EmailService;
import com.isakayabasi.maintermproject.service.Impl.QuestionServiceImpl;
import com.isakayabasi.maintermproject.service.Impl.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;


@Controller
public class QuizController {



	@Autowired
	ResultRepo rRepo;

	@Autowired
	Result result;

	@Autowired
	ResultServiceImpl resultService;

	@Autowired
	QuestionServiceImpl qService;

	@Autowired
	IUserRepository uRepo;

	@Autowired
	EmailService emailService;


	Boolean submitted = false;
	int enterValue=1;

	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}

	@ModelAttribute("result")
	public Result getResultSatisfaction() {
		return result;
	}

	@GetMapping("/indexex")
	public String home() {
		return "indexex.html";
	}


	@PostMapping("/quiz")
	public String quiz(Model m, Principal principal, RedirectAttributes ra, User user) {


		submitted = false;


			if (principal.getName()== "admin@gmail.com"){
				result.setUsername(principal.getName());
				QuestionForm qForm = qService.getQuestions();
				m.addAttribute("qForm", qForm);

				return "quiz.html";

			}else {

				User currentUser = uRepo.findByEmail(principal.getName());
				enterValue = currentUser.getEnterValue();

				if (enterValue == 1) {
					ra.addFlashAttribute("warning", "You entered this survey before");
					return "redirect:indexex";
				} else {

					result.setUsername(currentUser.getFirstName());

					result.setEmail(principal.getName());

					QuestionForm qForm = qService.getQuestions();
					m.addAttribute("qForm", qForm);

					currentUser = uRepo.findByEmail(principal.getName());

					return "quiz.html";
				}


			}

	}

	/////////////////////////////////


	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm,String messageId, Model m,Principal principal,User user) {

		try{

		if(!submitted) {



			result.setSatisfaction(resultService.getResultSatisfaction(qForm));
			result.setMessageId(resultService.getMessageId(qForm));
			result.setTotalCorrect(resultService.getResultPoint(qForm));

			result.setMessageId(messageId);

			resultService.saveSatisfaction(result);

			emailService.sendEmail(principal);





			submitted = true;
			if (principal.getName()== "admin@gmail.com"){
			}
			else {
			User currentUser = uRepo.findByEmail(principal.getName());
			currentUser.setEnterValue(1);
			uRepo.save(currentUser);
		}}
		return "result.html";

	} catch (Exception e) {
		return "indexexex";
	}
	}

	@GetMapping("/score")
	public String score(Model m) {
		List<Result> sList = resultService.getTopScore();
		m.addAttribute("sList", sList);
		//m.addAttribute("messages",messageService.getAllMessage());


		return "scoreboard.html";
	}

	@PostMapping("/Result")
	public String saveScore(@ModelAttribute("result")Result result){
		resultService.saveScore(result);
		return "redirect:/Result";
	}



}
