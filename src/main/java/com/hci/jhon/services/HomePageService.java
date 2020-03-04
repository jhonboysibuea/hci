package com.hci.jhon.services;

import com.hci.jhon.model.response.CustomResponse;



public interface HomePageService {
    CustomResponse getHomePageByUser(int userId);
}
