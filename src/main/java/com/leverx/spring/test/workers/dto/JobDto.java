package com.leverx.spring.test.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class JobDto extends ShortcutJobDto {

    private Set<ShortcutWorkerDto> workersDto;
}
