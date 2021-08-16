package com.leverx.spring.test.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortcutWorkerDto {

    private UUID id;

    @NotBlank(message = "Name must not be blank!")
    private String name;

    @NotBlank(message = "Password must not be blank!")
    private String password;
}
