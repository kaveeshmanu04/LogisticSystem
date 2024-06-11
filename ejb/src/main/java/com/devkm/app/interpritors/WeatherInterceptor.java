package com.devkm.app.interpritors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.Map;
import java.util.Random;

public class WeatherInterceptor {
    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        Map<String, Object> contextData = invocationContext.getContextData();
        int estimatedTime = (int)contextData.get("estimatedTime");
        String  traffic = (String) contextData.get("traffic");
        String selectedRoad = (String) contextData.get("selectedRoad");
        String weatherStatus = "";
        if (estimatedTime!=0){
            Random random = new Random();
            int randomNumber = random.nextInt(3);
                if (randomNumber == 0) {
                    weatherStatus = "Rainy day";
                    estimatedTime += 9;
                } else if (randomNumber == 1) {
                    weatherStatus = "Going to rain";
                    estimatedTime += 4;
                } else if (randomNumber == 2) {
                    weatherStatus = "Sunny day";
                    estimatedTime += 1;
                }
        }else {

        }
        System.out.println("Route "+selectedRoad+" traffic "+traffic+" weather"+weatherStatus+"estimated time"+estimatedTime);
        return invocationContext.proceed();
    }
}
