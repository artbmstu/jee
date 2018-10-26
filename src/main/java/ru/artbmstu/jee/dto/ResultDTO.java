package ru.artbmstu.jee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement
@NoArgsConstructor
public class ResultDTO {

    protected Boolean success;
    protected String message;
}