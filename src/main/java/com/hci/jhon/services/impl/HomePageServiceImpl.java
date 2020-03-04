package com.hci.jhon.services.impl;

import com.hci.jhon.model.User;
import com.hci.jhon.model.enums.ServiceStatus;
import com.hci.jhon.model.response.CustomResponse;
import com.hci.jhon.repository.UserRepository;
import com.hci.jhon.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    UserRepository userRepository;

    @Override
    public CustomResponse getHomePageByUser(int userId) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isPresent()){
            return CustomResponse.build(ServiceStatus.SUCCESS,userOptional.get().getGroupHomePage().getModulesList());
        }else{
            return CustomResponse.buildNotFound();
        }
    }
}
