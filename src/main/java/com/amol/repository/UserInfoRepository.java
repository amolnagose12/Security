package com.amol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
