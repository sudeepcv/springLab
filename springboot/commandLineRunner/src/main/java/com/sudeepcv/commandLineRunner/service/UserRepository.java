package com.sudeepcv.commandLineRunner.service;

import com.sudeepcv.commandLineRunner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
