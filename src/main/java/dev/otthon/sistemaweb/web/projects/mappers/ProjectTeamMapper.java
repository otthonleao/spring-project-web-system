package dev.otthon.sistemaweb.web.projects.mappers;

import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectTeamListItem;

public interface ProjectTeamMapper {

    ProjectTeamListItem toProjectTeamListItem(Employee employee);

}
