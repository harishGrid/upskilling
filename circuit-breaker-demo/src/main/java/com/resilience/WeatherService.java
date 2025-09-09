package com.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private static final String WEATHER_SERVICE = "weatherService";

    // Only CircuitBreaker should have fallback
    @CircuitBreaker(name = WEATHER_SERVICE, fallbackMethod = "getWeatherFallback")
    @Retry(name = WEATHER_SERVICE) // no fallback here
    public String getWeather(String city) {
        System.out.println("Calling external API for city: " + city);

        // Simulate random failure
        if (Math.random() > 0.5) {
            throw new RuntimeException("External API call failed!");
        }

        return "Weather in " + city + " is Sunny 🌞";
    }

    // ✅ Fallback must match method signature + Throwable last
    public String getWeatherFallback(String city, Throwable t) {
        System.out.println("Fallback triggered for city: " + city + ", reason: " + t.getMessage());
        return "Weather data not available for " + city + ". Please try later ⛅";
    }
}
