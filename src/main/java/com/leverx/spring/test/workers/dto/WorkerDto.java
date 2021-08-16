package com.leverx.spring.test.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class WorkerDto extends ShortcutWorkerDto {

    private Set<ShortcutJobDto> jobsDto;
}
