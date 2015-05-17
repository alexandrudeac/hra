package ro.adc.hra.employee;

import javax.inject.Inject;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ro.adc.hra.base.OperationInfo;

import com.google.common.collect.ImmutableList;

@Controller
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @Inject
    public EmployeeController(final EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @RequestMapping("/employee")
    public String list(final ModelMap modelMap) {
        final FindEmployeesRq rq = new FindEmployeesRq();
        final FindEmployeesRs rs = employeeServices.findEmployees(rq);
        modelMap.put("employees", rs.getEmployees());
        modelMap.put("errors", rs.getMessages().getErrors());
        modelMap.put("infos", rs.getMessages().getInfos());
        return "employee/list";
    }

    @RequestMapping(value="/employee/create",method=RequestMethod.GET)
    public String createEmployee(final ModelMap modelMap) {
        modelMap.put("employeeDetail", new EmployeeDetail());
        return "employee/create";
    }

    @RequestMapping(value="/employee/create",method=RequestMethod.POST)
    public String createEmployee(@ModelAttribute("employeeDetail") final EmployeeDetail employee,
            final RedirectAttributes redirectAttributes,
            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addAttribute("employeeDetail", employee);
            return "/redirect:employe/create";
        }
        final ModifyEmployeesRq rq = new ModifyEmployeesRq();
        final EmployeeCreation creation = new EmployeeCreation();
        creation.setEmployeeDetail(employee);
        rq.setOperations(ImmutableList.<EmployeeOperation>builder().add(creation).build());
        rq.setOperatorLocale("ro");;
        rq.setOperationInfo(new OperationInfo("user-todo", LocalDateTime.now()));
        employeeServices.modifyEmployees(rq);
        return "redirect:/employee";
    }

    @RequestMapping(value="/employee/{code}/update",method=RequestMethod.GET)
    public String showUpdateEmployee(@PathVariable("code") final String code,
            final ModelMap modelMap) {
        final FindEmployeesRq rq = new FindEmployeesRq();
        rq.setExpectsOne(Boolean.TRUE);
        rq.setEmployeeCodeIs(code);
        final FindEmployeesRs rs = employeeServices.findEmployees(rq);
        modelMap.put("employeeRecord", rs.getEmployee());
        if (!modelMap.containsKey("employeeDetail")) {
            modelMap.put("employeeDetail", rs.getEmployee().getDetail());
            modelMap.put("errors", rs.getMessages().getErrors());
            modelMap.put("infos", rs.getMessages().getInfos());
        }
        return "employee/update";
    }

    @RequestMapping(value="/employee/{code}/update", method=RequestMethod.POST)
    public String updateEmployee(@PathVariable("code") final String code,
            @ModelAttribute("employeeDetail") final EmployeeDetail employee,
            final RedirectAttributes redirectAttributes,
            final BindingResult bindingResult) {
        final ModifyEmployeesRq rq = new ModifyEmployeesRq();
        final EmployeeModification emplModif = new EmployeeModification();
        emplModif.setEmployeeCode(code);
        emplModif.setName(employee.getBasic().getName());
        rq.setOperations(ImmutableList.<EmployeeOperation>builder().add(emplModif).build());
        rq.setOperatorLocale("ro");;
        rq.setOperationInfo(new OperationInfo("user-todo", LocalDateTime.now()));
        final ModifyEmployeesRs rs = employeeServices.modifyEmployees(rq);
        redirectAttributes.addFlashAttribute("employeeDetail", employee);
        redirectAttributes.addFlashAttribute("errors", rs.getMessages().getErrors());
        redirectAttributes.addFlashAttribute("infos", rs.getMessages().getInfos());
        return String.format("redirect:/employee/%s/update", code);
    }
}
