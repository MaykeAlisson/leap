package br.com.redesenhe.leap.application.ports.in;

import br.com.redesenhe.leap.application.core.domain.model.User;

public interface InsertUserInputPort {

    User execute(User user);
}
