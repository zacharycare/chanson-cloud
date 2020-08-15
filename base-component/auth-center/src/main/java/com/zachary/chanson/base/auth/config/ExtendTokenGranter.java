package com.zachary.chanson.base.auth.config;

import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;

import java.util.List;

public class ExtendTokenGranter extends CompositeTokenGranter {
    public ExtendTokenGranter(List<TokenGranter> tokenGranters) {
        super(tokenGranters);
    }
}
