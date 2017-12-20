package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by nik on 10.12.17.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long userId);
    void changeUserData(String name, long id, int level);
}
