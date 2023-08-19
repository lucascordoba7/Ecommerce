package com.lucas.ecommerce.integrationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class ApiTestBase {

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected final String serverBasePath() {
        return "http://localhost:" + port;
    }
}
