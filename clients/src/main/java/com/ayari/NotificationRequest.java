package com.ayari;

public record NotificationRequest(Integer toCustomerId,
                                  String toCustomerName,
                                  String message) {
}
