package deltaanalytics.ftirweb.repository;

import deltaanalytics.FtirWebGuiApplication;
import deltaanalytics.ftirweb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(FtirWebGuiApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        userRepository.save(user);

        assertThat(userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword()).size(), is(1));
    }

    @Test
    public void existsByAccountPassword(){
        User user = new User();
        String account = "mala";
        user.setAccount(account);
        String password = "pawo";
        user.setPassword(password);

        userRepository.save(user);

        assertThat(userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword()).size(), is(1));
    }

    @Test
    public void existsByAccountPasswordNotExist(){
        User user = new User();
        String account = "mala";
        user.setAccount(account);
        String password = "pawo";
        user.setPassword(password);

        userRepository.save(user);

        assertThat(userRepository.findByAccountAndPassword("nicht", "bekannt").size(), is(0));
    }
}
