package io.williamwu.springdb;

import org.apache.commons.codec.digest.DigestUtils;

public class Functions {
    public static String toSHA256(String raw) {
        // takes last 6 digits of student name's SHA256 value
        String fullSHA256 = DigestUtils.sha256Hex(raw);
        return fullSHA256.substring(fullSHA256.length() - 6);
    }
}
