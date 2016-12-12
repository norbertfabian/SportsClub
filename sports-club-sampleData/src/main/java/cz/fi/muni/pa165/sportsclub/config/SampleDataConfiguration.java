package cz.fi.muni.pa165.sportsclub.config;

import cz.fi.muni.pa165.sportsclub.loader.SampleDataLoader;
import cz.muni.fi.pa165.sportsclub.SpringContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Fabian Norbert
 */

@Configuration
@Import(SpringContextConfiguration.class)
@ComponentScan(basePackageClasses = SampleDataLoader.class)
public class SampleDataConfiguration {

    final static Logger log = LoggerFactory.getLogger(SampleDataConfiguration.class);

    @Inject
    private SampleDataLoader loader;

    @PostConstruct
    public void dataLoading() throws IOException, ParseException {
        log.debug("dataLoading()");
        loader.loadData();
    }
}
