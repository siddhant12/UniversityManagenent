package com.universitymanagement.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/user/**";
   // public static final String H2_URL = "h2-console/**";
    public static final String SECRET = "SecretKeyToGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 90_000 * 10000; //90 sec
}
