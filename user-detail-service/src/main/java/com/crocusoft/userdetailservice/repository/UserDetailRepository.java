package com.crocusoft.userdetailservice.repository;

import com.crocusoft.userdetailservice.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    Optional<UserDetail> findUserDetailByIdentityNumber(String identityNumber);

}
