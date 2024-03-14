package br.com.redesenhe.leap.application.ports.out;

import br.com.redesenhe.leap.application.core.domain.model.User;

public interface InsertUserOutputPort {

    User execute(User user);
}
