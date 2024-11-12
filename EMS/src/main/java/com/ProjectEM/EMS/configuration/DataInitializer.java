//package com.ProjectEM.EMS.configuration;
//
//import com.ProjectEM.EMS.entity.Role;
//import com.ProjectEM.EMS.repository.RoleRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer {
//
//    private final RoleRepository roleRepository;
//
//    public DataInitializer(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Bean
//    public commandLineRunner initRoles(){
//        return args -> {
//            if(roleRepository.findByName("ROLE_ADMIN").isEmpty()){
//                roleRepository.save(new Role("ROLE_ADMIN"));
//            }
//            if(roleRepository.findByName("ROLE_USER").isEmpty()){
//                roleRepository.save(new Role("ROLE_USER"));
//            }
//
//        };
//    }
//}
