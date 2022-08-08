package com.isakayabasi.maintermproject.controller;


import com.isakayabasi.maintermproject.model.Message;
import com.isakayabasi.maintermproject.service.Service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        super();
        this.messageService = messageService;
    }

    //handler method to handle list messages and view and return
    @GetMapping("/messages")
    public String listMessages(Model model){
        model.addAttribute("messages",messageService.getAllMessage());
        return "messages";
    }
    @GetMapping("/messages/new")
    public String createMessageForm(Model model){

        //Create student object to hold message form data
        Message message = new Message();
        model.addAttribute("message",message);
        return "create_message";

    }

    @PostMapping("/messages")
    public String saveMessage(@ModelAttribute("message") Message message){
        messageService.saveMessage(message);
        return "redirect:/messages";
    }

    @GetMapping("/messages/{id}")
    public String deleteMessage(@PathVariable Long id){

        messageService.deleteMessageById(id);
        return "redirect:/messages";
    }


}