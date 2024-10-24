package com.suprevida.suprevida.commons;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class BaseController {
    protected Map<String, Object> response = new HashMap<>();
}
