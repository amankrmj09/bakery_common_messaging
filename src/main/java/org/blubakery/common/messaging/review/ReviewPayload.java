package org.blubakery.common.messaging.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPayload {
    private String reviewId;
    private String productId;
    private String userId;
    private String userName;
    private Integer rating;
    private String comment;
    private LocalDateTime timestamp;
    private String action; // e.g., "CREATED", "DELETED"
    private Double averageRating;
    private Integer totalReviews;
}
