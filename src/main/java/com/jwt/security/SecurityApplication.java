package com.jwt.security;

import com.jwt.security.entity.User;
import com.jwt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SecurityApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @PostConstruct
    public void initUsers() {
        List<User> userList = Stream.of(
                new User(101, "admin", "admin", "admin@ad.com"),
                new User(102, "user1", "user1", "user1@ad.com"),
                new User(103, "user2", "user2", "user2@ad.com")
        ).collect(Collectors.toList());
        this.userRepository.saveAll(userList);
    }

}
