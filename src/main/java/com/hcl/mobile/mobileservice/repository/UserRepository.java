package com.hcl.mobile.mobileservice.repository;

import com.hcl.mobile.mobileservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(final Long userId);

    @Transactional
    @Modifying
    @Query("update user set status = ?1 where userId = ?2")
    void updateStatus(final String status, final Long userId);

    @Transactional
    @Modifying
    @Query("update user set mobileNo = ?1 where userId = ?2")
    void updateMobileNumber(final long mobileNo, final Long userId);
}
