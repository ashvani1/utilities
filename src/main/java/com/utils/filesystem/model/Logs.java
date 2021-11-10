package com.utils.filesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logs {
    String id;
    String state;
    String type;
    String host;
    Long timestamp;
}
