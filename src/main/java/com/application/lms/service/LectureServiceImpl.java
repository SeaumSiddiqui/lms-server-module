package com.application.lms.service;

import com.application.lms.domain.Lecture;
import com.application.lms.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl {
    private final LectureRepository repository;

    public List<Lecture> lectureList() {
        return repository.findAll();
    }

    public Lecture createLecture(Lecture lecture) {
        return repository.save(lecture);
    }

    public void deleteLecture(Long id) {
        repository.deleteById(id);
    }
}
