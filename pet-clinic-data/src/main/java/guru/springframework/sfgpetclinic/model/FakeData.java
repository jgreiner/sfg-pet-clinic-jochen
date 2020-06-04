package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.springframework.beans.factory.InitializingBean;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeData implements InitializingBean {

    private String username;
    private String password;


    @Override
    public void afterPropertiesSet() {
        System.out.println("+++++ init FakeData: " + username + ":" + password);
    }
}
