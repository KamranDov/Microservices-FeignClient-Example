package com.crocusoft.userdetailservice.service;

import com.crocusoft.userdetailservice.domain.UserDetail;
import com.crocusoft.userdetailservice.repository.UserDetailRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class UserDetailService {

    private final UserDetailRepository userDetailRepository;

    public UserDetail getUserDetailByIdentityNumber(String identityNumber) {
        return userDetailRepository.findUserDetailByIdentityNumber(identityNumber).orElseThrow(
                () -> new RuntimeException("User not found"));
    }
}
