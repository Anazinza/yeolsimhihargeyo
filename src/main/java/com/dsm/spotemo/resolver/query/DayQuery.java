package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.entity.WriteDate;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DayQuery implements GraphQLQueryResolver {
    private final AuthenticationFacade authentication;



    @PreAuthorize("authenticated()")
    public WriteDate getWriteDay() {
        // token 없을시 접근 못하게...
        return authentication.getAccountDetails().getAccount().getWriteDate();
    }
}