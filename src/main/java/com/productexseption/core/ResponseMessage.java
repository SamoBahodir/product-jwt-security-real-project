package com.productexseption.core;

import com.productexseption.core.dto.Name;
import com.productexseption.core.enumeration.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private MessageType type;
    private Name message;
}
