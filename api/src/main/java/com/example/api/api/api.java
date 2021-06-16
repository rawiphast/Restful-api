package com.example.api.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.api.Exception.UserNotFoundException;
import com.example.api.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class api {
    private List<User> Users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public api() {

    }

    @GetMapping("/api")
    public List<User> getUsers() {
        return Users;
    }

    @GetMapping("/api/{id}")
    public User getUsers1(@PathVariable long id) {
        return Users.stream().filter(result -> result.getId() == id).findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api")
    public void addUser(@RequestBody User user) {
        Users.add(new User(counter.getAndIncrement(), user.getFirstName(), user.getLastName(), user.getUsername(),
                user.getPassword(), user.getEmail()));
    }

    @PutMapping("/api/{id}")
    public void editUser(@RequestBody User user, @PathVariable long id) {
        Users.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
            result.setFirstName(user.getFirstName());
        }, () -> {
            throw new UserNotFoundException(id);
        });
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/{id}")
    public void deleteUser(@PathVariable long id) {
        Users.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
            Users.remove(result);
        }, () -> {
            throw new UserNotFoundException(id);
        });
    }
}
