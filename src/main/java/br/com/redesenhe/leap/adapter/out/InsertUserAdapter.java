package br.com.redesenhe.leap.adapter.out;

import br.com.redesenhe.leap.adapter.out.repository.UserRepository;
import br.com.redesenhe.leap.adapter.in.mapper.UserMapper;
import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import br.com.redesenhe.leap.adapter.out.repository.mapper.UserEntityMapper;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.out.InsertUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertUserAdapter implements InsertUserOutputPort {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper mapper;

    @Override
    public User execute(User user) {
        System.out.println(user.getName());
        var entity = this.mapper.toUserEntity(user);
        var result = this.userRepository.save(entity);
        return mapper.toUser(result);
    }
}
