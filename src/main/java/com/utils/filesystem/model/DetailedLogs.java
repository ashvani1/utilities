package com.utils.filesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedLogs {
    Logs logs;
    boolean alert;
    Long duration;
}
