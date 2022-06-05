package projekt_bdbt.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import projekt_bdbt.SpringApplication.CRUD.Address;
import projekt_bdbt.SpringApplication.CRUD.AddressDAO;
import projekt_bdbt.SpringApplication.CRUD.Employee;
import projekt_bdbt.SpringApplication.CRUD.EmployeeDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private EmployeeDAO employeedao;
    @Autowired
    private AddressDAO addressdao;


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/main_operator").setViewName("operator/main_operator");
        registry.addViewController("/main_klient").setViewName("klient/main_klient");
        registry.addViewController("/main_konsultant").setViewName("konsultant/main_konsultant");
        registry.addViewController("/main_pracownik").setViewName("pracownik/main_pracownik");
        registry.addViewController("/main_sprzedawca").setViewName("sprzedawca/main_sprzedawca");
    }

    @Controller
    public class DashboardController {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else if
            (request.isUserInRole
                            ("OPERATOR")) {
                return "redirect:/main_operator";
            } else if
            (request.isUserInRole
                            ("KLIENT")) {
                return "redirect:/main_klient";
            } else if
            (request.isUserInRole
                            ("KONSULTANT")) {
                return "redirect:/main_konsultant";
            } else if
            (request.isUserInRole
                            ("PRACOWNIK")) {
                return "redirect:/main_pracownik";
            } else if
            (request.isUserInRole
                            ("SPRZEDAWCA")) {
                return "redirect:/main_sprzedawca";
            }else {
                return "redirect:/index";
            }
        }


        //wczytywanie danych do tabel na index
        @RequestMapping(value = {"/"})
        public String showHomePage(Model model) {
            //TABELA PRACOWNICY
            List<Employee> listEmployee = employeedao.list();
            model.addAttribute("listEmployee", listEmployee);

            //TABELA ADRESOW
            List<Address> listAddress = addressdao.list();
            model.addAttribute("listAddress", listAddress);

            return "index";
        }

        //TABELA PRACOWNIKOW
        //zapisywanie
        @RequestMapping(value = {"/newEmployee"})
        public String showNewFormEmployee(Model model) {
            Employee employee = new Employee();
            model.addAttribute("employee", employee);
            return "CRUD/new_form_employee";
        }
        @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
        public String saveEmployee(@ModelAttribute("employee") Employee employee) {
            employeedao.save(employee);
            return "redirect:/";
        }

        //edycja i update
        @RequestMapping("/editEmployee/{ID_PRACOWNIKA}")
        public ModelAndView showEditFormEmployee(@PathVariable(name = "ID_PRACOWNIKA") int id) {
            ModelAndView mav = new ModelAndView("CRUD/edit_form_employee");
            Employee employee = employeedao.get(id);
            mav.addObject("employee", employee);
            return mav;
        }

        @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
        public String updateEmployee(@ModelAttribute("employee") Employee employee) {
            employeedao.update(employee);
            return "redirect:/";
        }

        //usun
        @RequestMapping("/deleteEmployee/{ID_PRACOWNIKA}")
        public String deleteEmployee(@PathVariable(name = "ID_PRACOWNIKA") int id) {
            employeedao.delete(id);
            return "redirect:/";
        }


        //TABELA ADRESY
        //zapisywanie
        @RequestMapping(value = {"/newAddress"})
        public String showNewFormAddress(Model model) {
            Address address = new Address();
            model.addAttribute("address", address);
            return "CRUD/new_form_address";
        }
        @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
        public String saveAddress(@ModelAttribute("address") Address address) {
            addressdao.save(address);
            return "redirect:/";
        }
        //edycja i update
        @RequestMapping("/editAddress/{ID_ADRESU}")
        public ModelAndView showEditFormAddress(@PathVariable(name = "ID_ADRESU") int id) {
            ModelAndView mav = new ModelAndView("CRUD/edit_form_address");
            Address address = addressdao.get(id);
            mav.addObject("address", address);
            return mav;
        }
        @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
        public String updateAddress(@ModelAttribute("address") Address address) {
            addressdao.update(address);
            return "redirect:/";
        }
        //usun
        @RequestMapping("/deleteAddress/{ID_ADRESU}")
        public String deleteAddress(@PathVariable(name = "ID_ADRESU") int id) {
            addressdao.delete(id);
            return "redirect:/";
        }



        //perspektywy
        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }

        @RequestMapping(value = {"/main_operator"})
        public String showOperatorPage(Model model) {
            return "operator/main_operator";
        }

        @RequestMapping(value = {"/main_klient"})
        public String showKlientPage(Model model) {
            return "klient/main_klient";
        }

        @RequestMapping(value = {"/main_konsultant"})
        public String showKonsultantPage(Model model) {
            return "konsultant/main_konsultant";
        }

        @RequestMapping(value = {"/main_pracownik"})
        public String showPracownikPage(Model model) {
            return "pracownik/main_pracownik";
        }

        @RequestMapping(value = {"/main_sprzedawca"})
        public String showSprzedawcaPage(Model model) {
            return "sprzedawca/main_sprzedawca";
        }
    }

}
