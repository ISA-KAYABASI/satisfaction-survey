package com.isakayabasi.maintermproject.service.Impl;

import com.isakayabasi.maintermproject.model.Message;
import com.isakayabasi.maintermproject.repository.MessageRepository;
import com.isakayabasi.maintermproject.service.Service.MessageService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messsageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        super();
        this.messsageRepository = messageRepository;
    }


    @Override
    public List<Message> getAllMessage() {
        return messsageRepository.findAll();
    }

    @Override
    public Message saveMessage(Message message) {
        return messsageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messsageRepository.findById(id).get();
    }

    @Override
    public void deleteMessageById(Long id) {
        messsageRepository.deleteById(id);}
}