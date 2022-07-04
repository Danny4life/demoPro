package com.example.demopro.repository;

import com.example.demopro.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    Optional<UsersModel> findByLoginAndPassword(String login, String password);

    Optional<UsersModel> findFirstByLogin(String login);
}
