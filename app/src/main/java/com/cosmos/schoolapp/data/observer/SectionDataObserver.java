package com.cosmos.schoolapp.data.observer;

import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.data.entity.Student;

public interface SectionDataObserver {
  void onSectionUpdated(Section section);
}
