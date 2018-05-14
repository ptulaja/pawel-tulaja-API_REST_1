package com.crud.tasks.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesTrello {

    @JsonProperty("votes")
    private Integer votes;

    @JsonProperty("attachmentsByType")
    private Attachment attachmentsByType;
}
