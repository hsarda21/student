package com.college.student.formatters;

import com.college.student.model.Stream;
import com.college.student.services.StreamService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class StreamFormatter implements Formatter<Stream>
{
    private final StreamService streamService;

    public StreamFormatter(StreamService streamService) {
        this.streamService = streamService;
    }

    @Override
    public String print(Stream stream, Locale locale) {
        return stream.getStreamName();
    }

    @Override
    public Stream parse(String text, Locale locale) throws ParseException {
        Collection<Stream> findStreams = streamService.findAll();

        for (Stream stream : findStreams) {
            findStreams.forEach(stream1 -> System.out.println(stream1.getStreamName()));
            if (stream.getStreamName().equalsIgnoreCase(text)) {
                return stream;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
