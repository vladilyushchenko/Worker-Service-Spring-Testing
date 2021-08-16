package com.leverx.spring.test.workers.controller;

import com.google.common.collect.Lists;
import com.leverx.spring.test.workers.dto.PhoneDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private List<PhoneDto> phones = Lists.newArrayList(
            new PhoneDto("B4-", "+375-33-333-33-33", "Belarus"),
            new PhoneDto("A1", "+375-22-222-22-22", "Russian")
    );

    @GetMapping
    public ResponseEntity<List<PhoneDto>> findPhones() {
        return ok(phones);
    }

    @PostMapping
    public ResponseEntity<PhoneDto> postPhone(@RequestBody @Valid PhoneDto phoneDto) {
        phones.add(phoneDto);
        return ok(phoneDto);
    }
}
