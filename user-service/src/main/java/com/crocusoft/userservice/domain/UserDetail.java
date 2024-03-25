package com.crocusoft.userservice.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetail {

    String identityNumber;
    String phoneNumber;
    String email;
    String address;
}
