package ru.artbmstu.jee.dto;

public class FailDTO extends ResultDTO {

    {
        success = false;
    }

    public FailDTO(Exception e){
        message = e.getMessage();
    }
}