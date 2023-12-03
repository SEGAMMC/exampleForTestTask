package ru.test_task.service;

import org.springframework.stereotype.Service;
import ru.test_task.dto.ResultCheckResponse;
import ru.test_task.dto.StringRequest;
import ru.test_task.entity.MethodType;

@Service
public interface CheckerService {
    ResultCheckResponse checkString(StringRequest str, MethodType method);

}
