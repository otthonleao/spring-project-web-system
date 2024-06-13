package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeProjectListItem;

public interface EmployeeProjectMapper {

    EmployeeProjectListItem toEmployeeProjectListItem(Project project);

}
