package com.upstartcommerce.pim.domain.config;

import com.upstartcommerce.pim.domain.converter.I18NStringReadConverter;
import com.upstartcommerce.pim.domain.converter.I18NStringWriteConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    final I18NStringWriteConverter i18NStringWriteConverter;
    final I18NStringReadConverter i18NStringReadConverter;
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String writeSideKeySpace;


    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDataCenter;

    @Value("${spring.data.cassandra.query-timeout:5000}")
    private long queryTimeout;

    public CassandraConfig(
            I18NStringReadConverter i18NStringReadConverter,
            I18NStringWriteConverter i18NStringWriteConverter
    ) {
        this.i18NStringReadConverter = i18NStringReadConverter;
        this.i18NStringWriteConverter = i18NStringWriteConverter;
    }

    @PostConstruct
    public void printConfig() {
        System.out.println("Cassandra contact points: " + contactPoints);
        System.out.println("Cassandra port: " + port);
        System.out.println("Cassandra datacenter: " + localDataCenter);
        System.out.println("Cassandra keyspace: " + writeSideKeySpace);
    }

    @Override
    protected String getKeyspaceName() {
        return this.writeSideKeySpace;
    }

    @Override
    protected String getContactPoints() {
        return this.contactPoints;
    }

    public long getQueryTimeout() {
        return this.queryTimeout;
    }

    @Override
    public String getLocalDataCenter() {
        return localDataCenter;
    }

    @Override
    protected int getPort() {
        return this.port;
    }

    @Override
    public CassandraCustomConversions customConversions() {
        return new CassandraCustomConversions(
                Arrays.asList(
                        i18NStringWriteConverter,
                        i18NStringReadConverter));

    }
}
