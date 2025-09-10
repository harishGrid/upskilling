package com.batch;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job importUserJob;

    @GetMapping("/start")
    public ResponseEntity<String> startBatchJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            jobLauncher.run(importUserJob, jobParameters);
            return ResponseEntity.ok("Batch job started successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error starting batch job: " + e.getMessage());
        }
    }
}