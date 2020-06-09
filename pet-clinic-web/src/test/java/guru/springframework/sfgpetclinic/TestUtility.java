package guru.springframework.sfgpetclinic;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class TestUtility {

    public static ResultActions checkControllerUrl(
            MockMvc mockMvc,
            String url,
            String viewName
    ) throws Exception {
        ResultActions m = mockMvc.perform(get(url)).andExpect(status().is(200));
        if (viewName != null) {
            m.andExpect(view().name(viewName));
        }
        return m;

    }

}
