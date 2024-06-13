package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeProjectListItem;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProjectMapperImpl implements EmployeeProjectMapper {

    @Override
    public EmployeeProjectListItem toEmployeeProjectListItem(Project project) {
        return EmployeeProjectListItem.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }

}
