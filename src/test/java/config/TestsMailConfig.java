package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.MailConfig;

@Configuration
@Import({MailConfig.class})
@ComponentScan(PackageNamesTest.API)
public class TestsMailConfig {

}
