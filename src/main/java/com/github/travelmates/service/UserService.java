package com.github.travelmates.service;

import com.github.travelmates.exception.UserNotFoundException;
import com.github.travelmates.model.User;
import com.github.travelmates.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(Long id) {
        validateId(id);
        return findUserOrThrow(id);
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }
    }

    private User findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}