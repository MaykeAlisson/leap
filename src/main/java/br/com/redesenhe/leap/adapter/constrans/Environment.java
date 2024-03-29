package br.com.redesenhe.leap.adapter.constrans;

public interface Environment {

    /**
     * @apiNote Spring Profiles
     */
    String SPRING_PROFILES_ACTIVE = "SPRING_PROFILES_ACTIVE";
    String DEV = "dev";

    /**
     * @apiNote USER ROLES
     */

    String ROLE_BASIC = "USER";

    /**
     * @apiNote JWT
     */

    String PRE_FIX_TOKEN = "token";
    String BEARER_TYPE = "Bearer ";
    String TOKEN_SECRET = PRE_FIX_TOKEN + "Secret";

    /**
     * @apiNote Open API
     */
    String OPEN_API_BEARER_TYPE = "Token";

    /**
     * @apiNote brapi
     */
    String PRE_FIX_BRAPI = "brapi";
    String BRAPI_URL_FIND_TICKET = PRE_FIX_BRAPI + "FindTicket";
}
