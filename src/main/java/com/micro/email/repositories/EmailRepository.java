package com.micro.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
