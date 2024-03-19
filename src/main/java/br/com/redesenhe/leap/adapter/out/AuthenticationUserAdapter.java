package br.com.redesenhe.leap.adapter.out;

import br.com.redesenhe.leap.adapter.out.repository.UserRepository;
import br.com.redesenhe.leap.adapter.out.repository.exception.ResourceNotFoundException;
import br.com.redesenhe.leap.adapter.out.repository.mapper.UserEntityMapper;
import br.com.redesenhe.leap.application.core.domain.exception.BusinessExceptionHandler;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.in.AuthenticationUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.redesenhe.leap.adapter.provider.Encryption.check;
import static br.com.redesenhe.leap.adapter.provider.Encryption.encriptar;
import static java.lang.String.format;

@Component
public class AuthenticationUserAdapter implements AuthenticationUserInputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper mapper;

    @Override
    public User execute(User user) {
        final var result =  this.userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException(format("Não foi encontrado usuario com o email %s", user.getEmail())));

        if(!check(user.getPassword(), result.getPassword()))
            throw  new BusinessExceptionHandler("Senha invalida");

        return mapper.toUser(result);
    }
}
