package com.isakayabasi.maintermproject.service.Service;

import java.security.Principal;

public interface EmailService {

    public String sendEmail(Principal principal);

}
