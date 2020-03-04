/*
 * Copyright (c) 2020.  Author Jhon
 */

package com.hci.jhon.services;

import com.hci.jhon.model.GroupHomePage;
import com.hci.jhon.model.Modules;
import com.hci.jhon.model.User;
import com.hci.jhon.model.response.CustomResponse;
import com.hci.jhon.repository.UserRepository;
import com.hci.jhon.services.impl.HomePageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@Slf4j
public class HomePageServicesTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private HomePageServiceImpl homePageService = new HomePageServiceImpl();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserIsNotNullButModuleNull(){
        when(userRepository.findById(anyInt())).thenReturn(userMock());
        final CustomResponse customResponse= homePageService.getHomePageByUser(anyInt());
        Assert.assertEquals(customResponse.getMessage(),"General Success");
        Assert.assertEquals(customResponse.getData(),null);
        Assert.assertEquals((List< Modules >)customResponse.getData(),userMock().get().getGroupHomePage().getModulesList());

    }

    @Test
    public void testUserIsNotNullAndModuleNotNull(){
        when(userRepository.findById(anyInt())).thenReturn(userMockModule());
        final CustomResponse customResponse= homePageService.getHomePageByUser(anyInt());
        Assert.assertEquals(customResponse.getMessage(),"General Success");
        Assert.assertEquals((List< Modules >)customResponse.getData(),userMock().get().getGroupHomePage().getModulesList());

    }

    private Optional<User> userMock(){
       GroupHomePage groupHomePage=GroupHomePage.builder().id(1).name("group").build();
       User user= User.builder()
                .name("JHon")
                .groupHomePage(groupHomePage)
                .build();
        return Optional.of(user);
    }
    private Optional<User> userMockModule(){
        GroupHomePage groupHomePage=GroupHomePage.builder().id(1).name("group").build();
        Modules.builder().groupHomePage(groupHomePage).id(1).moduleName("PRODUCTCARD").moduleOrder(1).build();

        User user= User.builder()
                .name("JHon")
                .groupHomePage(groupHomePage)
                .build();
        return Optional.of(user);
    }


}
