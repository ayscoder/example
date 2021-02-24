//package com.ays.example.all;
//
//import com.ays.example.all.entity.ExampleEntity;
//import com.ays.example.all.utils.JSONUtils;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class ExampleIntegrationTests {
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @LocalServerPort
//    int randomServerPort;
//
//    @Test
//    public void testSaveExample_200OK() throws URISyntaxException {
//        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/examples/";
//        URI uri = new URI(baseUrl);
//        ExampleEntity example = new ExampleEntity();
//        example.setName("ML");
//        example.setDescription("Its magic language");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        HttpEntity<ExampleEntity> request = new HttpEntity<>(example, headers);
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//
//        //Verify request succeed
//        Assert.assertEquals(201, result.getStatusCodeValue());
//    }
//
//    @Test
//    public void testFindOne_200OK() throws Exception {
//        String baseUrl = "http://localhost:" + randomServerPort + "/v1/examples/";
//        URI uri = new URI(baseUrl);
//        ExampleEntity example = new ExampleEntity();
//        example.setName("ML");
//        example.setDescription("Its magic language");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        HttpEntity<ExampleEntity> request = new HttpEntity<>(example, headers);
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//
//        //find
//        String id = JSONUtils.getValue(result.getBody(), "data");
//        baseUrl = "http://localhost:" + randomServerPort + "/v1/examples/" + id;
//        uri = new URI(baseUrl);
//        ResponseEntity<String> findOneResult = this.restTemplate.getForEntity(uri, String.class);
//        HttpStatus statusCode = findOneResult.getStatusCode();
//        String body = findOneResult.getBody();
//
//        //Verify request succeed
//        Assert.assertEquals(200, statusCode.value());
//
//        //delete
//        baseUrl = "http://localhost:" + randomServerPort + "/v1/examples/" + id;
//        uri = new URI(baseUrl);
//        findOneResult = this.restTemplate.exchange(uri, HttpMethod.DELETE, null, String.class);
//        statusCode = findOneResult.getStatusCode();
//
//        Assert.assertEquals(200, statusCode.value());
//    }
//}
