package com.hci.jhon.repository;

import com.hci.jhon.model.GroupHomePage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupHomePageRepository extends JpaRepository<GroupHomePage, Integer> {

}
