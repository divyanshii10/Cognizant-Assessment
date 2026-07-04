package com.cognizant;

public interface UserRepository {
    String getUserDetails(int userId);
    void saveUser(int userId, String name);
}
