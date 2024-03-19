package br.com.redesenhe.leap.application.ports.in;

import br.com.redesenhe.leap.application.core.domain.model.User;

public interface AuthenticationUserInputPort {

    User execute(User user);
}
