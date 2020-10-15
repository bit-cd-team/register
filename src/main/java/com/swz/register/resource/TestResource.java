package com.swz.register.resource;

import com.swz.register.common.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class TestResource {

    @GetMapping("/set")
    public String[] set(@RequestParam String key,@RequestParam String value) {
        boolean set = RedisUtil.set(key, value);
        System.out.println(set);

        return new String[]{key, value};
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        String s = (String) RedisUtil.get(key);
        System.out.println(s);
        return s;
    }

}
