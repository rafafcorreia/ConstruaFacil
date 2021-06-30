package apiTests;

import org.testng.annotations.Test;
import java.io.IOException;

public class ApiTests {
    @Test
    public void ApiTestes() throws IOException {
        Pet pet = new Pet();
        User user = new User();
        Store store = new Store();
        pet.suiteDeTestes();
        user.suiteDeTestes();
        store.incluirPedido();
    }
}
