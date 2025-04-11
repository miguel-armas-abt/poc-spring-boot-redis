package com.demo.poc.entrypoint.search.repository;

import com.demo.poc.commons.custom.enums.Platform;
import com.demo.poc.entrypoint.search.repository.wrapper.TokenResponseWrapper;

public interface TokenRepository {

    TokenResponseWrapper getToken();

    boolean supports(Platform platform);
}
