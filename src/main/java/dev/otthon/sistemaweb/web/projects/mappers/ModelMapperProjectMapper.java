package dev.otthon.sistemaweb.web.projects.mappers;

import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectDetails;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectForm;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectListItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "modelmapper"
)
public class ModelMapperProjectMapper implements ProjectMapper {

    private final ModelMapper modelMapper;

    @Override
    public ProjectListItem toProjectListItem(Project project) {
        return modelMapper.map(project, ProjectListItem.class);
    }

    @Override
    public ProjectDetails toProjectDetails(Project project) {
        return modelMapper.map(project, ProjectDetails.class);
    }

    @Override
    public Project toProject(ProjectForm projectForm) {
        return modelMapper.map(projectForm, Project.class);
    }

    @Override
    public ProjectForm toProjectForm(Project project) {
        return modelMapper.map(project, ProjectForm.class);
    }
}
