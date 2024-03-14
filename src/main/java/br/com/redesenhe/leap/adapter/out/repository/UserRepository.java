package br.com.redesenhe.leap.adapter.out.repository;

import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
