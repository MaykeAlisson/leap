package br.com.redesenhe.leap.application.core.usecase;

import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.in.InsertUserInputPort;
import br.com.redesenhe.leap.application.ports.out.InsertUserOutputPort;

public class InsertUserUseCase implements InsertUserInputPort {

    private final InsertUserOutputPort insertUserOutputPort;

    public InsertUserUseCase(InsertUserOutputPort insertUserOutputPort) {
        this.insertUserOutputPort = insertUserOutputPort;
    }

    @Override
    public User execute(User user){
        return this.insertUserOutputPort.execute(user);
    }
}
