package ru.test_task.service;

import org.springframework.stereotype.Service;
import ru.test_task.dto.ResultCheckResponse;
import ru.test_task.dto.StringRequest;
import ru.test_task.entity.MethodType;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Сервис для работы со строками
 */
@Service
public class CheckerServiceImpl implements CheckerService {

    /**
     * Метод определения количества повторяющихся символов
     */
    @Override
    public ResultCheckResponse checkString(StringRequest string, MethodType method) {
        String str = string.getString();
        if (str.length() < 1) return new ResultCheckResponse("");

        SortedSet<Map.Entry<Character, Integer>> sortedString =
                new TreeSet<>((o1, o2) -> {
                    int result = o2.getValue().compareTo(o1.getValue());
                    return result != 0 ? result : 1;
                });

        Map<Character, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (resultMap.containsKey(str.charAt(i))) {
                int repeat = resultMap.get(str.charAt(i));
                resultMap.put(str.charAt(i), ++repeat);
            } else {
                resultMap.put(str.charAt(i), 1);
            }
        }

        sortedString.addAll(resultMap.entrySet());

        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<Character, Integer> next : sortedString) {
            if (method.equals(MethodType.GET)) {
                resultString.append("\"")
                        .append(next.getKey())
                        .append("\": ")
                        .append(next.getValue())
                        .append(", ");
            } else {
                resultString.append(next.getKey())
                        .append(": ")
                        .append(next.getValue())
                        .append(", ");
            }
        }
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.deleteCharAt(resultString.length() - 1);

        return new ResultCheckResponse(resultString.toString());
    }
}


