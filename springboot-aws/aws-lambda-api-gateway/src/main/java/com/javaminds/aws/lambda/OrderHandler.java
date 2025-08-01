package com.javaminds.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.javaminds.aws.lambda.domain.Order;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.List;

public class OrderHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, List<Order>> {
}
