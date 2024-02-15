package com.cosmos.schoolapp.observer;

import com.cosmos.schoolapp.entity.Section;

public interface SectionDataObserver {
  void onSectionUpdated(Section section);
}
