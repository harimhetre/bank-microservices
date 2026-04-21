package com.bank.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FiltersUtility {

    public static final String CORRELATION_ID = "X-Correlation-Id";

    public String getCorrelationId(HttpHeaders headers) {
       if (headers.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = headers.get(CORRELATION_ID);
           if (requestHeaderList != null) {
               return requestHeaderList.stream().findFirst().get();
           }
       }
        return null;
    }

    public ServerWebExchange setRequestHeaders(ServerWebExchange serverWebExchange, String name, String value) {
        return serverWebExchange.mutate().request(serverWebExchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeaders(exchange, CORRELATION_ID, correlationId);
    }
}
