package com.leverx.spring.test.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortcutJobDto {

    private Long id;

    @NotBlank(message = "Name must not be blank!")
    private String name;
}
