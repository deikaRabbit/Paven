package com.paven.db.repository;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by deika on 2017/7/21.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.paven.model" })
@EnableJpaRepositories(basePackages = { "com.paven.db.repository" })
@EnableTransactionManagement
public class JpaConfiguration {
}
