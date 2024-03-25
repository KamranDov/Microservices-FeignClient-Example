package com.crocusoft.userservice.feign;

import com.crocusoft.userservice.domain.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "localhost:8051/user-detail", name = "user-detail")
public interface UserDetailClient {

    @GetMapping("{identityNumber}")
    ResponseEntity<UserDetail> getUserDetailByIdentityNumber(@PathVariable("identityNumber") String identityNumber);
}
