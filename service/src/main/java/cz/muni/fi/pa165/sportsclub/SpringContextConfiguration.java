package cz.muni.fi.pa165.sportsclub;

import cz.muni.fi.pa165.sportsclub.PersistenceSampleApplicationContext;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by norbert on 5.11.16.
 */

@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackages = {"cz.muni.fi.pa165.sportsclub"})
public class SpringContextConfiguration {

    @Bean
    public Mapper dozer(){
        return new DozerBeanMapper();
    }
}