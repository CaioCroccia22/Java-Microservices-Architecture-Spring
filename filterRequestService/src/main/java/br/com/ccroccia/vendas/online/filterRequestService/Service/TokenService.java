package br.com.ccroccia.vendas.online.filterRequestService.Service;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.time.LocalTime;



@Service
public class TokenService {

    @Value("${spring.secret}")
    private String secret;

    @Value("${spring.expiration}")
    private long expiration;

    @Value("${spring.emissor}")
    private String emissor;

    public String createToken(String subject){

        var dateExpiration = this.getDataExpiration();


        return subject;
    };

    private LocalTime getDataExpiration(){
        return LocalTime.now().plusHours(3L);
    }

}
