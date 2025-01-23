package com.ydova.schoolapp.observer;

import com.ydova.schoolapp.entity.Section;

public interface SectionDataObserver {
  void onSectionUpdated(Section section);
}
