package com.cosmos.schoolapp.data;

@FunctionalInterface
public interface RepositoryListener<T> {
  void onUserChange(T user);
}
