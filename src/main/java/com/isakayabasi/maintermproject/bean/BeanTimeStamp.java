package com.isakayabasi.maintermproject.bean;

import com.isakayabasi.maintermproject.timeStamp.TimeStampImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class BeanTimeStamp {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new TimeStampImpl();
    }
}
