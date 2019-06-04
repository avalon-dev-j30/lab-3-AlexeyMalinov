package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDeleteAction implements Action {

    Path source;

    public FileDeleteAction(String source) {
        this.source = Paths.get(source);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        synchronized (mutex) {
            try {
                Files.delete(source);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        source = null;
    }
}
