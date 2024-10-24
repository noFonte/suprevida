package com.suprevida.suprevida.commons;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController {
    protected Map<String, String> response = new HashMap<>();
}
