package com.example.RestfulApi.repository;

import com.example.RestfulApi.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByIdOrMobile(int id, String mobile);
    @Modifying
    @Query(value = "UPDATE account set is_deleted = ?1 where id = ?2", nativeQuery = true)
    void removeAccount(boolean isDeleted, int id);

}
