package com.cognizant;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserInfo(int userId) {
        return userRepository.getUserDetails(userId);
    }

    public void registerUser(int userId, String name) {
        userRepository.saveUser(userId, name);
    }
}
