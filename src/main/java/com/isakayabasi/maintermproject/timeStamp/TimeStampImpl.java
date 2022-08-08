package com.isakayabasi.maintermproject.timeStamp;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class TimeStampImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Isa Kayabasi");
    }
}
