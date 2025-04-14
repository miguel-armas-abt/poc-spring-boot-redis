package com.demo.poc.entrypoint.management.service;

import java.util.List;

import com.demo.poc.entrypoint.management.enums.Platform;
import com.demo.poc.commons.custom.exceptions.NoSuchTokenCacheHelperException;
import com.demo.poc.commons.custom.properties.ApplicationProperties;
import com.demo.poc.entrypoint.management.helper.TokenCacheHelper;
import com.demo.poc.entrypoint.management.repository.wrapper.TokenResponseWrapper;

public interface TokenManagementService {

  TokenResponseWrapper getToken(Platform platform);

  void cleanToken(Platform platform);

  default TokenCacheHelper selectCacheHelper(List<TokenCacheHelper> tokenCacheHelpers,
                                             ApplicationProperties properties) {

    Class<?> selectedClass = properties.getSelectorClass().get(TokenCacheHelper.TOKEN_CACHE_HELPER_SELECTOR);
    return tokenCacheHelpers.stream()
        .filter(tokenCacheHelper -> tokenCacheHelper.supports(selectedClass))
        .findFirst()
        .orElseThrow(NoSuchTokenCacheHelperException::new);
  }
}
