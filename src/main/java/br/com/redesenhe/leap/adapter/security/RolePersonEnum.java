package br.com.redesenhe.leap.adapter.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString(of = "type")
@AllArgsConstructor
@Getter
public enum RolePersonEnum {

    NONE("ROLE_NONE"),
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String type;

}
