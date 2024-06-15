package dev.otthon.sistemaweb.web.projects.mappers;

import dev.otthon.sistemaweb.core.exceptions.ClientNotFoundException;
import dev.otthon.sistemaweb.core.exceptions.EmployeeNotFoundException;
import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.core.models.Project;
import dev.otthon.sistemaweb.core.repositories.ClientRepository;
import dev.otthon.sistemaweb.core.repositories.EmployeeRepository;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectDetails;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectForm;
import dev.otthon.sistemaweb.web.projects.dtos.ProjectListItem;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "local"
)
public class ProjectMapperImpl implements ProjectMapper {

    private final ClientRepository clientRepository;
    private final ProjectTeamMapper projectTeamMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public ProjectListItem toProjectListItem(Project project) {
        return ProjectListItem.builder()
                .id(project.getId())
                .name(project.getName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .client(project.getClient().getName())
                .manager(project.getManager().getName())
                .budget(project.getBudget())
                .build();
    }

    @Override
    public ProjectDetails toProjectDetails(Project project) {
        var team = project.getTeam()
                .stream()
                .map(projectTeamMapper::toProjectTeamListItem)
                .toList();

        return ProjectDetails.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .budget(project.getBudget())
                .cost(project.getCost())
                .client(project.getClient().getName())
                .manager(project.getManager().getName())
                .team(team)
                .build();
    }

    @Override
    public Project toProject(ProjectForm projectForm) {
        var client = clientRepository.findById(projectForm.getClient())
                .orElseThrow(ClientNotFoundException::new);

        var manager = employeeRepository.findById(projectForm.getManager())
                .orElseThrow(EmployeeNotFoundException::new);

        var team = employeeRepository.findAllById(projectForm.getTeam());

        return Project.builder()
                .name(projectForm.getName())
                .description(projectForm.getDescription())
                .startDate(projectForm.getStartDate())
                .endDate(projectForm.getEndDate())
                .budget(projectForm.getBudget())
                .cost(projectForm.getCost())
                .client(client)
                .manager(manager)
                .team(team)
                .build();
    }

    @Override
    public ProjectForm toProjectForm(Project project) {
        var team = project.getTeam()
                .stream()
                .map(Employee::getId)
                .toList();

        return ProjectForm.builder()
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .budget(project.getBudget())
                .cost(project.getCost())
                .client(project.getClient().getId())
                .manager(project.getManager().getId())
                .team(team)
                .build();
    }

}
