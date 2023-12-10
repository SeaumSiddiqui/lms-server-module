package com.application.lms.service;

import com.application.lms.domain.Lecture;
import com.application.lms.exception.LectureNotFoundException;
import com.application.lms.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl {
    private final LectureRepository repository;

    public Lecture createLecture(Lecture lecture) {
        return repository.save(lecture);
    }

    public void deleteLecture(Long id) {

        if (!repository.existsById(id)) {
            throw new LectureNotFoundException("No lecture found");
        }
        repository.deleteById(id);
    }
}
