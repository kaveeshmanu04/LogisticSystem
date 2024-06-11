package com.devkm.app.interpritors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.Map;
import java.util.Random;

public class RouteInterceptor {
    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        String ocationNow = (String) invocationContext.getParameters()[0];
        String location = (String) invocationContext.getParameters()[1];
        String finalDestination = (String) invocationContext.getParameters()[2];
        String status = (String) invocationContext.getParameters()[3];
        String info = (String) invocationContext.getParameters()[4];
        Map<String, Object> contextData = invocationContext.getContextData();
        if (status.equals("processing")) {
            contextData.put("selectedRoad","NONE");
            contextData.put("estimatedTime",0);
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(6);
            String selectedRoad = "";
            int estimatedTime = 0;
            if (randomNumber == 0) {
                selectedRoad = "A1 ROAD";
                estimatedTime = 1;
            } else if (randomNumber == 1) {
                selectedRoad = "B1 ROAD";
                estimatedTime = 2;
            } else if (randomNumber == 2) {
                selectedRoad = "A9 ROAD";
                estimatedTime = 5;
            }else if (randomNumber == 3) {
                selectedRoad = "A10 ROAD";
                estimatedTime = 4;
            } else if (randomNumber == 4) {
                selectedRoad = "B12 ROAD";
                estimatedTime = 8;
            } else if (randomNumber == 5) {
                selectedRoad = "A3 ROAD";
                estimatedTime = 9;
            }

            contextData.put("selectedRoad",selectedRoad);
            contextData.put("estimatedTime",estimatedTime);
        }

        return invocationContext.proceed();

    }
}
