package com.samedov.polyahtonapp.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

@Data
public class WsEventDto {
    private ObjectType objectType;
    private EventType eventType;
    @JsonRawValue
    private String body;

    public WsEventDto(ObjectType objectType, EventType eventType, String body) {
        this.objectType = objectType;
        this.eventType = eventType;
        this.body = body;
    }
}
