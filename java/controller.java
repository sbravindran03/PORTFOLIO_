import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String listProjects(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "project/list"; // Create a Thymeleaf template for listing projects
    }

    @GetMapping("/{id}")
    public String viewProject(@PathVariable Long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "project/view"; // Create a Thymeleaf template for viewing a project
    }

    @GetMapping("/new")
    public String showProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project/form"; // Create a Thymeleaf template for adding a new project
    }

    @PostMapping
    public String saveProject(@ModelAttribute Project project) {
        projectService.saveProject(project);
        return "redirect:/projects";
    }
}
