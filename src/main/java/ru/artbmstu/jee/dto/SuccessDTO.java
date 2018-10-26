package ru.artbmstu.jee.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "success")
public class SuccessDTO extends ResultDTO{

    {
        success = true;
        message = "";
    }
}