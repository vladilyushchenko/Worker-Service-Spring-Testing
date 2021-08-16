package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.ShortcutJobDto;
import com.leverx.spring.test.workers.entity.Job;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ShortcutJobMapper {

    ShortcutJobDto mapEntityToShortcutDto(Job job);

    Set<ShortcutJobDto> mapEntitySetToShortCutDto(Set<Job> jobs);
}
