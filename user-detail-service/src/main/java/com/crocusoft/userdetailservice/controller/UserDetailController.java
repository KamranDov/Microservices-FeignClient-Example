package com.crocusoft.userdetailservice.controller;

import com.crocusoft.userdetailservice.domain.UserDetail;
import com.crocusoft.userdetailservice.repository.UserDetailRepository;
import com.crocusoft.userdetailservice.service.UserDetailService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Builder
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-detail")
public class UserDetailController {

    private final UserDetailService userDetailService;
    private final UserDetailRepository userDetailRepository;

    @GetMapping("/{identityNumber}")
    public ResponseEntity<UserDetail> getUserDetailByIdentityNumber(@PathVariable("identityNumber") String identityNumber) {
        return new ResponseEntity<>(userDetailService.getUserDetailByIdentityNumber(identityNumber), HttpStatus.OK);
    }

    @PostMapping("/add-user")
    public ResponseEntity<UserDetail> createUserDetail() {
        UserDetail userDetail = UserDetail.builder()
                .identityNumber("123456789")
                .phoneNumber("0503228854")
                .email("user@crocusoft.com")
                .address("Baku").build();
        userDetailRepository.save(userDetail);
        return new ResponseEntity<>(userDetail, HttpStatus.CREATED);
    }
}
