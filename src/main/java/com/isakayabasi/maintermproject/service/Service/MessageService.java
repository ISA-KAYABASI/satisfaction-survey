package com.isakayabasi.maintermproject.service.Service;


import com.isakayabasi.maintermproject.model.Message;


import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();

    Message saveMessage(Message message);

    Message getMessageById(Long id);

    void deleteMessageById(Long id);
}