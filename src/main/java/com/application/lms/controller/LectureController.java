package com.application.lms.controller;

import com.application.lms.domain.Lecture;
import com.application.lms.service.LectureServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureServiceImpl service;

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) {
        return ResponseEntity.ok(service.createLecture(lecture));
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity<String> deleteLecture(@PathVariable Long id) {
        service.deleteLecture(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
