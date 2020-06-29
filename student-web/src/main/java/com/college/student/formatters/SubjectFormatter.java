package com.college.student.formatters;

import com.college.student.model.Subject;
import com.college.student.services.SubjectService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class SubjectFormatter implements Formatter<Subject>
{
    private final SubjectService subjectService;

    public SubjectFormatter(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String print(Subject subject, Locale locale) {
        return subject.getSubjectName();
    }

    @Override
    public Subject parse(String text, Locale locale) throws ParseException {
        Collection<Subject> findSubjects = subjectService.findAll();

        for (Subject subject : findSubjects) {
            if (subject.getSubjectName().equals(text)) {
                return subject;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
