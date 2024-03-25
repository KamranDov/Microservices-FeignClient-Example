package com.crocusoft.userservice.service;

import com.crocusoft.userservice.domain.User;
import com.crocusoft.userservice.domain.UserDetail;
import com.crocusoft.userservice.feign.UserDetailClient;
import com.crocusoft.userservice.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailClient userDetailClient;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserAndDetail(String identityNumber) {
        UserDetail userDetail = userDetailClient.getUserDetailByIdentityNumber(identityNumber).getBody();
        User user = userRepository.findUsersByIdentityNumber(identityNumber).orElseThrow(
                () -> new RuntimeException("User not found"));
        user.setUserDetail(userDetail);
        return user;
    }
}
