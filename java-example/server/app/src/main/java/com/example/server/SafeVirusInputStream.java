package com.example.server;

import com.example.lib.Virus;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class SafeVirusInputStream extends ObjectInputStream {
    public SafeVirusInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass input) throws IOException, ClassNotFoundException {
        if (!input.getName().equals(Virus.class.getName())) {
            throw new InvalidClassException("unsupported class", input.getName());
        }

        return super.resolveClass(input);
    }
}
