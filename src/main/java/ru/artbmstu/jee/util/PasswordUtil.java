package ru.artbmstu.jee.util;

import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordUtil {

    @SneakyThrows
    public static String hashCode(final String value){
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        final byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        final byte[] hex = messageDigest.digest(bytes);
        return DatatypeConverter.printHexBinary(hex);
    }
}