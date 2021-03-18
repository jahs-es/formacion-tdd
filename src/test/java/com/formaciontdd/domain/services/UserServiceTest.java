package com.formaciontdd.domain.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.formaciontdd.domain.model.User;
import com.formaciontdd.domain.providers.UserProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

  @Mock
  private UserProvider userProvider;

  @InjectMocks
  private UserService sut;

  @Test
  public void shouldCallProvider() {

    final User user = User.builder().name("aname").build();

    sut.register(user);

    verify(userProvider, times(1)).save(user);
  }
}
