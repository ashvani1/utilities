package com.utils.filesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LogsDTO {
    @Id
    String id;
    Long duration;
    String type;
    String host;
    boolean alert;
}
