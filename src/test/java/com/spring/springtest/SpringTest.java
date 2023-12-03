package com.spring.springtest;

import org.junit.jupiter.api.Test;
import ru.test_task.dto.ResultCheckResponse;
import ru.test_task.dto.StringRequest;
import ru.test_task.entity.MethodType;
import ru.test_task.service.CheckerService;
import ru.test_task.service.CheckerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringTest {
    private final CheckerService checkerService = new CheckerServiceImpl();


    @Test
    void thenStringHelloTestStringByGet() {
        StringRequest stringRequest = new StringRequest("Hello");
        ResultCheckResponse resultCheckResponse = checkerService
                .checkString(stringRequest, MethodType.GET);
        assertEquals(resultCheckResponse.getResultString(), "\"l\": 2, \"H\": 1, \"e\": 1, \"o\": 1");
    }

    @Test
    void thenStringHelloTestStringByPost() {
        StringRequest stringRequest = new StringRequest("Hello");
        ResultCheckResponse resultCheckResponse = checkerService
                .checkString(stringRequest, MethodType.POST);
        assertEquals(resultCheckResponse.getResultString(), "l: 2, H: 1, e: 1, o: 1");
    }

    @Test
    void thenStringHelloTestResponseByGet() {
        StringRequest stringRequest = new StringRequest("Hello");
        ResultCheckResponse resultCheckResponse = checkerService
                .checkString(stringRequest, MethodType.GET);
        ResultCheckResponse resultCheckResponseTest = new ResultCheckResponse("\"l\": 2, \"H\": 1, \"e\": 1, \"o\": 1");
        assertEquals(resultCheckResponse, resultCheckResponseTest);
    }

    @Test
    void thenStringHelloTestResponseByPost() {
        StringRequest stringRequest = new StringRequest("Hello");
        ResultCheckResponse resultCheckResponse = checkerService
                .checkString(stringRequest, MethodType.POST);
        ResultCheckResponse resultCheckResponseTest = new ResultCheckResponse("l: 2, H: 1, e: 1, o: 1");
        assertEquals(resultCheckResponse, resultCheckResponseTest);
    }

    @Test
    void thenStringNotSymbolTestResponseByPost() {
        StringRequest stringRequest = new StringRequest("");
        ResultCheckResponse resultCheckResponse = checkerService
                .checkString(stringRequest, MethodType.POST);
        ResultCheckResponse resultCheckResponseTest = new ResultCheckResponse("");
        assertEquals(resultCheckResponse, resultCheckResponseTest);
    }

}
