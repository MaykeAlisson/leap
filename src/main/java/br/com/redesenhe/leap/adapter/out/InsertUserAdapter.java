package br.com.redesenhe.leap.adapter.out;

import br.com.redesenhe.leap.adapter.out.repository.UserRepository;
import br.com.redesenhe.leap.adapter.out.repository.mapper.UserEntityMapper;
import br.com.redesenhe.leap.application.core.domain.exception.BusinessExceptionHandler;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.out.InsertUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.redesenhe.leap.adapter.provider.Encryption.encriptar;
import static java.lang.String.format;

@Component
public class InsertUserAdapter implements InsertUserOutputPort {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper mapper;

    @Override
    public User execute(User user) {
        this.userRepository.findByEmail(user.getEmail())
                .ifPresent(entity -> {
                    throw new BusinessExceptionHandler(format("Usuario com o  email %s já cadatrado", user.getEmail()));
                });
        user.setPassword(encriptar(user.getPassword()));
        var entity = this.mapper.toUserEntity(user);
        var result = this.userRepository.save(entity);
        return mapper.toUser(result);
    }
}
