package com.cosmos.schoolapp;

@FunctionalInterface
public interface RepositoryListener<T> {
  void onUserChange(T user);
}
