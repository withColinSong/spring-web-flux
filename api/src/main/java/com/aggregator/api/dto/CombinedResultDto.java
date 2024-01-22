package com.aggregator.api.dto;

import com.aggregator.api.model.Type;
import com.aggregator.api.model.user.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CombinedResultDto {
    private final Long userId;
    private final Status status;
    private final Type type;
}
