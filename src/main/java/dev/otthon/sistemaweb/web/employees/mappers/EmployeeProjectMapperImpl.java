package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeProjectListItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "local"
)
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
