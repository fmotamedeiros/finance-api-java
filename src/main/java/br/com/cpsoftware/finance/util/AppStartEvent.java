package br.com.cpsoftware.finance.util;

import org.springframework.context.ApplicationListener;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import br.com.cpsoftware.finance.model.User;
import br.com.cpsoftware.finance.repository.UserRepository;

@Component
public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;

    public AppStartEvent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        List<User> users = this.userRepository.findAll();
        System.out.println(users.size());
    }

}
