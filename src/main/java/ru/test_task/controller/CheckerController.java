package ru.test_task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test_task.dto.ResultCheckResponse;
import ru.test_task.dto.StringRequest;
import ru.test_task.entity.MethodType;
import ru.test_task.service.CheckerService;

@RestController
@RequestMapping("/check")
@RequiredArgsConstructor
public class CheckerController {
    private final CheckerService checkerService;

    /**
     * Endpoint вызывающийся методом GET /check/{string}
     * @return string
     */
    @GetMapping("/{string}")
    public String checkStringGet(@PathVariable String string){
        StringRequest stringRequest = new StringRequest(string);
        return checkerService.checkString(stringRequest, MethodType.GET).getResultString();
    }

    /**
     * Endpoint вызывающийся методом POST /check
     * в теле запроса необходимо передать строку
     * @return ResultCheckResponse
     */

    @PostMapping
    public ResultCheckResponse checkStringPost(@RequestBody StringRequest string){
        return checkerService.checkString(string, MethodType.POST);
    }

}