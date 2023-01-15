package com.myDomain.SpringStore.repository;

import com.myDomain.SpringStore.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

}
