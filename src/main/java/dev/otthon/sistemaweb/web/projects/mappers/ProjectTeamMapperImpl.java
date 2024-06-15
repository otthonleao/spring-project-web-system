package dev.otthon.sistemaweb.web.projects.mappers;

import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectTeamListItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "local"
)
public class ProjectTeamMapperImpl implements ProjectTeamMapper {

    @Override
    public ProjectTeamListItem toProjectTeamListItem(Employee employee) {
        return ProjectTeamListItem.builder()
                .name(employee.getName())
                .position(employee.getPosition().getName())
                .build();
    }
}
