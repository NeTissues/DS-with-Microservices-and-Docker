package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
