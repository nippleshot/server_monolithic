package com.example.service;


import com.example.dao.LoginLogRepository;
import com.example.dao.UserRepository;
import com.example.domain.LoginLog;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoginLogRepository loginLogRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testHasMatchUser() throws Exception  {
        final User expectedUser = new User(1, "admin");
        expectedUser.setPassword("123456");
        given(userRepository.findUserByUserName(expectedUser.getUserName())).willReturn(expectedUser);

        final boolean expected = userService.hasMatchUser(expectedUser.getUserName(), expectedUser.getPassword());
        verify(userRepository, times(1)).findUserByUserName(expectedUser.getUserName());
        assertEquals(expected, true);
    }

    @Test
    public void testFindUserByUserName() throws Exception  {
        final User expectedUser = new User(1, "admin");
        expectedUser.setPassword("123456");

        given(userRepository.findUserByUserName(expectedUser.getUserName())).willReturn(expectedUser);

        final User actualUser = userService.findUserByUserName(expectedUser.getUserName());
        verify(userRepository, times(1)).findUserByUserName(expectedUser.getUserName());
        assertEquals(actualUser.getUserName(), expectedUser.getUserName());
        assertEquals(actualUser.getPassword(), expectedUser.getPassword());
    }

    @Test
    public void testSaveLog() throws Exception  {
        final User savingUser = new User(1, "admin");
        savingUser.setPassword("123456");
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUserId(savingUser.getUserId());
//        loginLog.setIp(savingUser.getLastIp());
//        loginLog.setLoginDate(savingUser.getLastVisit());

        final boolean saveUser = userService.saveLog(savingUser);
//        verify(loginLogRepository, atLeastOnce()).save(loginLog);
        assertEquals(saveUser, true);
    }

}
