/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mobileeng.abetterliving;

import ch.zhaw.mobileeng.abetterliving.boundary.*;
import ch.zhaw.mobileeng.abetterliving.model.*;
import ch.zhaw.mobileeng.abetterliving.repository.*;
import java.util.Date;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@SpringBootApplication
public class ABetterLiving extends ResourceConfig {

    public static void main(String[] args) {
        SpringApplication.run(ABetterLiving.class, args);
    }

    public ABetterLiving() {
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        register(CorsFilter.class);
        register(TaskService.class);
        register(ListService.class);
        register(UserService.class);
        register(AuthenticationService.class);
        register(JacksonHibernateConfig.class);
    }

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ListRepository listRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            //Actual date
            java.util.Date actualDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(actualDate.getTime());
            //Example user
            Users u = new Users();
            u.setEmail("ex@ex.ex");
            u.setUsername("ex");
            u.setAndHashPassword("ex");
            userRepository.save(u);
            u = new Users();
            u.setEmail("raphael@fuchs.hei");
            u.setUsername("raphael");
            u.setAndHashPassword("ex");
            userRepository.save(u);
            u = new Users();
            u.setEmail("jannik@meier.hei");
            u.setUsername("jannik");
            u.setAndHashPassword("ex");
            userRepository.save(u);
            u = new Users();
            u.setEmail("matthias@zehnder.hei");
            u.setUsername("matthias");
            u.setAndHashPassword("ex");
            userRepository.save(u);
            u = new Users();
            u.setEmail("julian@herrmann.hei");
            u.setUsername("julian");
            u.setAndHashPassword("ex");
            userRepository.save(u);
            //Example lists
            String[] standardList = {"Unsortiert", "Warten auf", "Irgendwann", "Kalender"};
            for (String list : standardList) {
                Lists l = new Lists();
                l.setName(list);
                l.setType("standard");
                listRepository.save(l);
            }
            //Example tasks
            Tasks t = new Tasks();
            t.setCreationDate(new Date());
            t.setDueDate(new Date());
            t.setTitle("Babyklappe");
            t.setNote("Ein Kind zur Babyklappe bringen.");
            t.setOwner(u);
            t.setPriority(1);
            t.setRequiredTime(new Date());
            t.setStatus(false);
            taskRepository.save(t);

            //Example tasks
            t = new Tasks();
            t.setTitle("Architekten suchen");
            t.setNote("Suche einen exkulsiven Architekten.");
            t.setOwner(u);
            t.setPriority(3);
            t.setStatus(false);
            t.setRequiredTime(new Date());
            t.setDueDate(new Date());
            t.setCreationDate(new Date());
            taskRepository.save(t);

            //Example tasks
            t = new Tasks();
            t.setTitle("Task 1 und 2 erledigen");
            t.setNote("Für einen geordneten Ablauf müssen natürlich die vorherigen Tasks erledigt werden.");
            t.setOwner(u);
            t.setPriority(2);
            t.setStatus(false);
            t.setRequiredTime(new Date());
            t.setDueDate(new Date());
            t.setCreationDate(new Date());
            taskRepository.save(t);

            //Example tasks
            t = new Tasks();
            t.setTitle("Richtige App für ToDo-Liste installieren");
            t.setNote("Diese App taugt kaum zum täglichen Gebrauch.");
            t.setOwner(u);
            t.setPriority(2);
            t.setStatus(false);
            t.setRequiredTime(new Date());
            t.setDueDate(new Date());
            t.setCreationDate(new Date());
            taskRepository.save(t);

            //Example tasks
            t = new Tasks();
            t.setTitle("Updates installieren");
            t.setNote("Sicherheitsupdates sind wichtig und sollte immer SOFORT installiert werden.");
            t.setOwner(u);
            t.setPriority(1);
            t.setStatus(true);
            t.setRequiredTime(new Date());
            t.setDueDate(new Date());
            t.setCreationDate(new Date());
            taskRepository.save(t);

            //Add project
            Lists p = new Lists();
            p.setName("Hausbau Roggenstrasse");
            p.setType("project");
            p.setUser(u);
            listRepository.save(p);
        };
    }
}
