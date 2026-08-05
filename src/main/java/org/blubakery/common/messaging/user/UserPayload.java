package org.blubakery.common.messaging.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {
    private UUID userId;
    private String email;
    private String firstName;
    private String lastName;
    private String action; // REGISTERED, UPDATED, DELETED, OTP_REQUESTED, PASSWORD_CHANGED, NEW_SIGN_IN
    private String otpCode;
    private Integer expiryMinutes;
    private String ipAddress;
    private String location;
    private LocalDateTime timestamp;
    private String phoneNumber;
}
