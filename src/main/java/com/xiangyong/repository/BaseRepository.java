package com.xiangyong.repository;

import com.xiangyong.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by yuxiangyong on 2017/5/11.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Number> extends JpaRepository<T,ID> {
    T findById(ID id);
}
