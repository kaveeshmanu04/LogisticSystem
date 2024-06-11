package com.devkm.app.interpritors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.Map;
import java.util.Random;

public class TrafficInterceptor {
    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        Map<String, Object> contextData = invocationContext.getContextData();
        int estimatedTime = (int) contextData.get("estimatedTime");
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String traffic = "";
        if (estimatedTime != 0) {
            if (randomNumber == 0) {
                traffic = "Maximum Traffic";
                estimatedTime += 8;
            } else if (randomNumber == 1) {
                traffic = "Moderate Traffic";
                estimatedTime += 3;
            } else if (randomNumber == 2) {
                traffic = "Lower Traffic";
                estimatedTime += 1;
            }
        } else {
          traffic="NONE";
        }
        contextData.put("estimatedTime",estimatedTime);
        contextData.put("traffic",traffic);
        return invocationContext.proceed();
    }
}
