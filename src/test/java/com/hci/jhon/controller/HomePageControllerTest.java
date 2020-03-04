
/*
 * Copyright (c) 2020.  Author Jhon
 */

package com.hci.jhon.controller;

import com.hci.jhon.model.GroupHomePage;
import com.hci.jhon.model.Modules;
import com.hci.jhon.model.response.CustomResponse;
import com.hci.jhon.services.HomePageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomePageControllerTest{

    @Mock
    private HomePageService service;

    @InjectMocks
    private HomePageController homePageController = new HomePageController();

    private MockMvc mvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(homePageController).addPlaceholderValue("homepage/{userId}","homepage/{userId}").build();
    }

    @Test
    public void getHomePageUserWhenModuleNotNull (){
        List<Modules> modulesList=new LinkedList<>();
        Modules e= Modules.builder().groupHomePage(
                        GroupHomePage
                        .builder()
                        .id(1)
                        .name("group1")
                        .build())
                .moduleName("ProductCard")
                .moduleOrder(1)
                .build();
        modulesList.add(e);
        when(service.getHomePageByUser(anyInt())).thenReturn(CustomResponse.buildSuccess(modulesList));
        final CustomResponse customResponse = homePageController.getHomePageByUser(anyInt());
        Assert.assertNotNull(customResponse);
        Assert.assertEquals(customResponse.getMessage(), "General Success");
        Assert.assertArrayEquals(new Object[]{customResponse.getData()}, new List[]{modulesList});

        verify(service, times(1)).getHomePageByUser(anyInt());
    }

    @Test
    public void getHomePageUserWhenModuleIsNull(){
        when(service.getHomePageByUser(anyInt())).thenReturn(CustomResponse.buildNotFound());
        final CustomResponse customResponse = homePageController.getHomePageByUser(anyInt());
        Assert.assertNotNull(customResponse);
        Assert.assertEquals(customResponse.getMessage(), "Data Not Found");
        Assert.assertEquals(customResponse.getData(), null);

        verify(service, times(1)).getHomePageByUser(anyInt());
    }

    @Test
    public void apiGetHomePageUserWhenModuleIsNotNull() throws Exception {
            List<Modules> modulesList=new LinkedList<>();
            Modules e= Modules.builder().moduleName("ProductCard").moduleOrder(1).build();
            modulesList.add(e);
            final String url = "/homepage/{userId}";
            when(service.getHomePageByUser(anyInt())).thenReturn(CustomResponse.buildSuccess(modulesList));
            mvc.perform(MockMvcRequestBuilders.get(url,anyInt()).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
            verify(service, times(1)).getHomePageByUser(anyInt());
            verifyNoMoreInteractions(service);

    }

}