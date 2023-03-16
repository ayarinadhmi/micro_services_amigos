package com.ayari;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value="NOTIFICATION"
)
public interface NotificationClient {
    @PostMapping(path="api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
