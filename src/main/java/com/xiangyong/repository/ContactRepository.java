package com.xiangyong.repository;

import com.xiangyong.entity.ContactInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
@Repository
public interface ContactRepository extends BaseRepository<ContactInfo,Long> {
    ContactInfo findByPhoneNumber(String phoneNumber);
    ContactInfo findByFirstNameOrLastName(String firstName, String lastName);
    ContactInfo findByEmailAddress(String emailAddress);
    @Cacheable(value = "contactCache")
    ContactInfo findById(long id);

    @CachePut(value = "contactCache", key = "#result.id")
    ContactInfo save(ContactInfo contactInfo);

    @CacheEvict("contactCache")
    void delete(long id);
}
