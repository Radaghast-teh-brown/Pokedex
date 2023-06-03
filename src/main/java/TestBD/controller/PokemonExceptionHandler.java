package TestBD.controller;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class PokemonExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env ) {
        ErrorType type = null;
        if (ex instanceof DataIntegrityViolationException) {
            type = ErrorType.BAD_REQUEST;
        } else {
            type = ErrorType.BAD_REQUEST;
        }
        return GraphqlErrorBuilder.newError(env)
                .message("Aviso:" + ex.getMessage())
                .errorType(type)
                .build();
    }





}
