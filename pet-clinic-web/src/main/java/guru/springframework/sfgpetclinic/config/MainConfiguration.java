package guru.springframework.sfgpetclinic.config;

import guru.springframework.sfgpetclinic.model.FakeData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:fakedata.properties"),
        @PropertySource("classpath:fakedata2.properties")
})
public class MainConfiguration {

    @Value("${guru.username}")
    String username;

    @Value("${guru.password}")
    String password;

    @Bean
    public FakeData fakeDataSource() {
        FakeData fd = new FakeData();
        fd.setPassword(password);
        fd.setUsername(username);
        return fd;
    }


}
