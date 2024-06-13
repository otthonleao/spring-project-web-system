package dev.otthon.sistemaweb.web.projects.mappers;

import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectDetails;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectForm;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectListItem;

public interface ProjectMapper {

    ProjectListItem toProjectListItem(Project project);

    ProjectDetails toProjectDetails(Project project);

    Project toProject(ProjectForm projectForm);

    ProjectForm toProjectForm(Project project);

}