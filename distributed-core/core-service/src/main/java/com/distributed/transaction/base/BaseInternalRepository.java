package com.distributed.transaction.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author ssk www.8win.com Inc.All rights reserved
 * @date 2018/07/18 下午 2:09
 * @since v1.0
 **/
@NoRepositoryBean
public interface BaseInternalRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
