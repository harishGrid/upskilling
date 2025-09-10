package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    // Use constructor-based dependency injection for core components
    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public ItemReader<User> reader() {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("users.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<User>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id", "name", "email");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                setTargetType(User.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<User, User> processor() {
        return new ItemProcessor<User, User>() {
            @Override
            public User process(User user) throws Exception {
                if (user.getEmail().contains("@")) {
                    return user;
                }
                return null;
            }
        };
    }

    // Spring will automatically inject the DataSource here when creating the bean
    @Bean
    public ItemWriter<User> writer(DataSource dataSource) {
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        // The fix: use double quotes around the table name "USER"
        writer.setSql("INSERT INTO users (id, name, email) VALUES (:id, :name, :email)");
        writer.setDataSource(dataSource);
        
        // Explicitly set the NamedParameterJdbcTemplate
        writer.setJdbcTemplate(new NamedParameterJdbcTemplate(dataSource));
        
        return writer;
    }

    // Spring will automatically inject the `step1` bean here
    @Bean
    public Job importUserJob(Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .start(step1)
                .build();
    }

    // Spring will automatically inject the other beans here to build the step
    @Bean
    public Step step1(ItemReader<User> reader, ItemProcessor<User, User> processor, ItemWriter<User> writer) {
        return new StepBuilder("step1", jobRepository)
                .<User, User>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}