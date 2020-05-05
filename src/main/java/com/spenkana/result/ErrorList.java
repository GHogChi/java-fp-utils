package com.spenkana.result;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

/**
 * Mutable list of Error objects.
 * Any subclass instances of SafeError are accepted - does not require
 * uniformity.
 * @see SafeError
 */
//TODO minimize: no instance methods: staticize and add "self" param
public class ErrorList extends SafeError<List<SafeError>> {
    private final List<SafeError> errors = new ArrayList<SafeError>();

    public ErrorList(List<SafeError> errors) {
        this.errors.addAll(errors);
    }

    public ErrorList() { }

    public ErrorList add(SafeError error){
       errors.add(error);
       return this;
    }

    public ErrorList add(String format, Object... args){
        this.add(new SimpleError(format(format, args)));
        return this;
    }

    @Override
    public String message() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < errors.size() -1; ++i){
            sb.append(errors.get(i).message())
                    .append(", ");
        }
        sb.append(errors.get(errors.size() - 1).message());
        return sb.toString();
        //TODO Streaming doesn't seem to work:
        // why does e end up mapping to the ErrorList itself? Causes
        // stack overflow.
//        return errors.stream().map(e -> message()).collect(joining(", "));
    }

    public List<SafeError> data() {
        return errors;
    }

    @Override
    public int errorCount() {
        return errors.size();
    }

    public boolean occurred() {
        return errorCount() > 0;
    }

    public void add(String message) {
        add(new SimpleError(message));
    }
}
