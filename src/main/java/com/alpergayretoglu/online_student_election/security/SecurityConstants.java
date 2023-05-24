package com.alpergayretoglu.online_student_election.security;

public class SecurityConstants {

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "OnlineStudentElection";
    public static final String TOKEN_AUDIENCE = "OnlineStudentElection";

    private SecurityConstants() {
    }

}
