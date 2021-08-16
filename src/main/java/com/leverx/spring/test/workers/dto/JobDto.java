package com.leverx.spring.test.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto extends ShortcutJobDto {

    private Set<ShortcutWorkerDto> workers;
}
