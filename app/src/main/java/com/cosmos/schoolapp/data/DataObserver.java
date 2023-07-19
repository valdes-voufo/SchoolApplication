package com.cosmos.schoolapp.data;

import com.cosmos.schoolapp.data.entity.Student;

public interface DataObserver<T>{
    void onDataUpdated(T data);
}




